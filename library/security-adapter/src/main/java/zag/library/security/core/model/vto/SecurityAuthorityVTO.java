package zag.library.security.core.model.vto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecurityAuthorityVTO implements GrantedAuthority {
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
