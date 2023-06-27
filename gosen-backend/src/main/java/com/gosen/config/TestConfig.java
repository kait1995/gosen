package com.gosen.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.gosen.model.DeviceSetting;
import com.gosen.model.GraphData;
import com.gosen.model.UserAccount;
import com.gosen.repository.DeviceSettingRepository;
import com.gosen.repository.GraphDataRepository;
import com.gosen.repository.UserAccountRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TestConfig implements ApplicationRunner{
	private final DeviceSettingRepository deviceSettingRepo;
	private final GraphDataRepository graphDataRepo;
	private final UserAccountRepository userAccountRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		DeviceSetting deviceSetting = DeviceSetting.builder()
				.title("test")
				.deviceNumber(Integer.toUnsignedLong(0))
				.isActivated(true)
				.useCamera(true)
				.useTimer(true)
				.timerStart("start")
				.timerEnd("end")
				.manualWatering(true)
				.status0(true)
				.status1(true)
				.status2(true)
				.status3(true)
				.status4(true)
				.status5(true)
				.status6(true)
				.status7(true)
				.status8(true)
				.status9(true)
				.build();
		
		UserAccount userAccount = UserAccount.builder()
				.userId(Integer.toUnsignedLong(0))
				.password("password")
				.profileImgLink("test")
				.build();
		
		GraphData graphData = GraphData.builder()
				.batteryStatus("100%")
				.signalStrength("100%")
				.humidity("100%")
				.temperature("10")
				.option0("test")
				.option1("test")
				.option2("test")
				.option3("test")
				.option4("test")
				.option5("test")
				.option6("test")
				.option7("test")
				.option8("test")
				.option9("test")
				.date("test")
				.deviceSetting(deviceSetting)
				.userAccount(userAccount)
				.build();
		
		deviceSettingRepo.save(deviceSetting);
		userAccountRepo.save(userAccount);
		graphDataRepo.save(graphData);
	}

}
