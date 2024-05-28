package CodeMaker.togetherLion.domain.post.model;

import lombok.Getter;

@Getter
public enum DealState {
    FIRST("첫번째단계"),
    SECOND("두번째단계");

    private final String message;

    DealState(String message) {
        this.message = message;
    }
}
