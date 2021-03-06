package org.ligoj.app.http.security;

import java.security.Principal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;

/**
 * Check the SSO authentication provider.
 */
public class TrustedAuthenticationProviderTest {

	@Test
	public void testAuthenticate() {
		final Authentication authentication = Mockito.mock(Authentication.class);
		final Principal principal = Mockito.mock(Principal.class);
		Mockito.when(principal.toString()).thenReturn("junit");
		Mockito.when(authentication.getPrincipal()).thenReturn(principal);
		final Authentication authenticate = new TrustedAuthenticationProvider().authenticate(authentication);
		Assertions.assertEquals("junit", authenticate.getPrincipal().toString());
	}

	@Test
	public void testAuthenticateMixedCase() {
		final Authentication authentication = Mockito.mock(Authentication.class);
		final Principal principal = Mockito.mock(Principal.class);
		Mockito.when(principal.toString()).thenReturn("jUniT");
		Mockito.when(authentication.getPrincipal()).thenReturn(principal);
		final Authentication authenticate = new TrustedAuthenticationProvider().authenticate(authentication);
		Assertions.assertEquals("junit", authenticate.getPrincipal().toString());
	}
}
