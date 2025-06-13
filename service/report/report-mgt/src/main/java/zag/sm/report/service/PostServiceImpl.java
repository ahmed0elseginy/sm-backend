package zag.sm.report.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import zag.library.session.api.service.RequestContext;
import zag.sm.report.model.vto.PostVTO;

import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_TOKEN;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final RestTemplate restTemplate;
    private final RequestContext context;

    @Override
    public PostVTO getPostById(Long postId) {

        String token = context.get(USER_TOKEN, String.class);

        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:9102/posts/" + postId + "/getSpecific")
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<PostVTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                PostVTO.class
        );

        return responseEntity.getBody();

    }

    @Override
    public void deletePostById(Long postId) {
        String token = context.get(USER_TOKEN, String.class);
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:9102/posts/" + postId).toUriString();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class);
    }

}
