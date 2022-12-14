package laurSpilca.tuto.nacer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

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
			   .authorizedGrantTypes("password");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		
		//liaison des users aux AuthorizationServerConfiguration.
		endpoints.authenticationManager(authenticationManager);
		
	}
	
}
