package CodeMaker.togetherLion.domain.user.dto.login.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class NicknameCheckRes {

    private boolean nicknameCheck;
}
