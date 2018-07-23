package com.cafe.waiter.security.auth;

import com.cafe.business.core.entity.user.User;
import com.cafe.business.core.service.user.UserService;
import com.cafe.business.core.service.user.exception.UserNotExistsForUserNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 5:36 PM
 */

@Service("waiterAuthService")
public class WaiterAuthenticator implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user;
        try {
            user = userService.getUserByUsername(username);
        } catch (final UserNotExistsForUserNameException ex) {
            throw new UsernameNotFoundException("User not found for username - " + username, ex);
        } catch (final Exception ex) {
            throw new UsernameNotFoundException("Error during authentication", ex);
        }
        return new WaiterAuth(user);
    }

    private class WaiterAuth implements UserDetails {

        private static final long serialVersionUID = -1173181914164338505L;

        // Properties
        private final User user;

        // Constructor
        public WaiterAuth(final User user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getUserRole().name()));
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getUserName();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

}
