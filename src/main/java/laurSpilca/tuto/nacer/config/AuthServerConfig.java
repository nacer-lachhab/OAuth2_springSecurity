package laurSpilca.tuto.nacer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer //active le seveur des authorisations.
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		clients.inMemory()
			   .withClient("client1")
			   .secret("secret1")
			   .scopes("read")
			   .authorizedGrantTypes("password","refresh_token")
			   //********************************************
			   .and()//second client with different grantType
			   //********************************************
			   .withClient("client2")
			   .secret("secret2")
			   .scopes("read")
			   .authorizedGrantTypes("authorization_code")
			   .redirectUris("https://localhost:9090")
			   //********************************************
			   .and()//second client with different grantType
			   //********************************************
			   .withClient("client3")
			   .secret("secret3")
			   .scopes("read")
			   .authorizedGrantTypes("client_credentials");
	}

	
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(converter());
	}
	
	@Bean
	public JwtAccessTokenConverter converter() {
		return new JwtAccessTokenConverter();
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		
		//liaison des users aux AuthorizationServerConfiguration.
		endpoints.authenticationManager(authenticationManager)
				 .tokenStore(tokenStore())
				 .accessTokenConverter(converter());
		
	}
	
}
