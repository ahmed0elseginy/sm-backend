package zag.sm.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import zag.sm.user.controller.generated.ProfileController;
import zag.sm.user.model.generated.UserProfileDTO;
import zag.sm.user.model.generated.UserProfileVTO;
import zag.sm.user.service.UserProfileService;

@RestController
@AllArgsConstructor
public class ProfileControllerImpl implements ProfileController {
    private final UserProfileService service;

    @Override
    public ResponseEntity<UserProfileVTO> _getUserProfile() {
        return ResponseEntity.ok(service.getUserProfileDetails());
    }

    @Override
    public ResponseEntity<Void> _updateUserProfile(UserProfileDTO userProfileDTO) {
        service.updateUserProfileDetails(userProfileDTO);
        return ResponseEntity.noContent().build();
    }
}
