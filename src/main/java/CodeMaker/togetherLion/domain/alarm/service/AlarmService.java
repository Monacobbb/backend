package CodeMaker.togetherLion.domain.alarm.service;

import CodeMaker.togetherLion.domain.alarm.dto.AlarmReq;
import CodeMaker.togetherLion.domain.alarm.entity.Alarm;
import CodeMaker.togetherLion.domain.alarm.repository.AlarmRepository;
import CodeMaker.togetherLion.domain.complain.service.ComplainService;
import CodeMaker.togetherLion.domain.user.entity.User;
import CodeMaker.togetherLion.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AlarmService {

    private final AlarmRepository alarmRepository;
    private final UserRepository userRepository;

    // 알림 등록
    public Alarm newAlarm(AlarmReq alarmReq) {
        User user = userRepository.findById(alarmReq.userId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 userId입니다."));

        Alarm alarm = alarmReq.toEntity(user);
        alarm.setAlarmDate(LocalDateTime.now());
        alarm.setAlarmCheck(false);
        alarmRepository.save(alarm);

        return alarm;
    }

}
