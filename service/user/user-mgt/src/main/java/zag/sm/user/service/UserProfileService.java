package zag.sm.user.service;

import zag.sm.user.model.generated.UserProfileDTO;
import zag.sm.user.model.generated.UserProfileVTO;

public interface UserProfileService {
    UserProfileVTO getUserProfileDetails();

    void updateUserProfileDetails(UserProfileDTO userProfileDTO);
}
