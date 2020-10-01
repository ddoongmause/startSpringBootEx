package com.ddoongmause;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.ddoongmause.domain.Member;
import com.ddoongmause.domain.Profile;
import com.ddoongmause.persistence.MemberRepository;
import com.ddoongmause.persistence.ProfileRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class ProfileTests {
	@Autowired
	MemberRepository memberRepo;
	
	@Autowired
	ProfileRepository profileRepo;
	
	@Test
	public void testInsertMembers() {
		IntStream.range(1, 101).forEach(i -> {
			Member member = new Member();
			member.setUid("user" + i);
			member.setUpw("pw" + i);
			member.setUname("사용자" + i);
			
			memberRepo.save(member);
		});
	}
	
	@Test
	public void testInsertProfile() {
		Member member = new Member();
		member.setUid("user1");
		
		for(int i=1; i<5; i++) {
			Profile profile1 = new Profile();
			profile1.setFname("face" + i + ".jpg");
			if( i ==1) {
				profile1.setCurrent(true);
			}
			profile1.setMember(member);
			profileRepo.save(profile1);
		}
	}
}