package CodeMaker.togetherLion.domain.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column
    private String loginId;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String nickname;

    @Lob
    private String profilePicture;

    @Column
    private String profileIntro;

    @Column
    private String phone;

    @Column
    private String userAddress; // 실제 주소

    @Column
    private String userLat; // 위도

    @Column
    private String userLong; // 경도

    @Column
    private String account;

    @Column
    private int loginCount;

    @Column
    private int complainCount;

    @Column
    private boolean userState; // 비활성화 여부
}
