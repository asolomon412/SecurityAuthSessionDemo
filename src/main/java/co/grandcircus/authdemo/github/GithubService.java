package co.grandcircus.authdemo.github;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.authdemo.entity.User;

@Component
public class GithubService {
	
	@Value("${github.client_secret}")
	private String clientSecret;

	/**
	 * Make an HTTP request to Github's server. Get an access token using the provided code.
	 */
	public String getGithubAccessToken(String code) {
		// We'll talk more about rest template in the coming days.
		Map<String, String> params = new HashMap<>();
		params.put("code", code);
		params.put("client_id", "e65d7894c8f3792ccdb8");
		params.put("client_secret", clientSecret);
		RestTemplate rest = new RestTemplate();
		@SuppressWarnings("unchecked")
		Map<String, String> response = rest.postForObject("https://github.com/login/oauth/access_token", params,
				Map.class);
		return response.get("access_token");
	}

	/**
	 * Make an HTTP request to Github's server. Use the access token to get the user details.
	 */
	public User getUserFromGithubApi(String accessToken) {
		// We'll talk more about rest template in the coming days.
		RestTemplate rest = new RestTemplate();
		String uri = "https://api.github.com/user?access_token=" + accessToken;
		GithubUser response = rest.getForObject(uri, GithubUser.class);
		User user = new User();
		response.copyToUser(user);
		return user;
	}
}
