package sn.minfinances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sn.minfinances.dao.IRoles;
import sn.minfinances.dao.IUser;
import sn.minfinances.entities.Roles;
import sn.minfinances.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@SpringBootApplication
public class EvalsecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EvalsecurityApplication.class, args);
	}

	@Autowired
	private IRoles rolesdao;
	@Autowired
	private IUser userdao;

	@Override
	public void run(String... args) throws Exception {
		Roles roles= new Roles();
		roles.setNom("ROLE_USERS");
		roles= rolesdao.save(roles);
		System.out.println(roles.getId());
		//User1
		User user=new User();
		user.setNom("Ndour");
		user.setPrenom("Sigababou");
		user.setEmail("fsndour@minfinances.sn");
		user.setEtat(1);
		BCryptPasswordEncoder pwdcrypt=new BCryptPasswordEncoder();
		String pwd=pwdcrypt.encode("passer@1234");
		user.setPassword(pwd);
		List<Roles> listRoles= new ArrayList<>();
		listRoles.add(rolesdao.getById(1));
		listRoles.add(rolesdao.getById(2));
		user=userdao.save(user);
		System.out.println(user.getId());

		//User2
		 user=new User();
		user.setNom("Ndiaye");
		user.setPrenom("Tidiane");
		user.setEmail("tndiaye@minfinances.sn");
		user.setEtat(1);
		pwd=pwdcrypt.encode("passer123#@");
		user.setPassword(pwd);
		List<Roles> listRoles1= new ArrayList<>();
		listRoles1.add(rolesdao.getById(1));
		user=userdao.save(user);
		System.out.println(user.getId());
	}


}
