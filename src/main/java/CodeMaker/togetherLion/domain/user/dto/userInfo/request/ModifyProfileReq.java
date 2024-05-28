package CodeMaker.togetherLion.domain.user.dto.userInfo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModifyProfileReq {

    private String nickname;
    private String profilePicture;
    private String profileIntro;
}
