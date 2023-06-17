package my.team.blocking.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import my.team.blocking.Reopcitry.UserReopcitry;
import my.team.blocking.Service.UserService;
import my.team.blocking.entity.User;

@Service
public class UserServiceImpl implements UserService ,UserDetailsService{
@Autowired
private UserReopcitry reopcitry;
	
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
@Override
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
		return this.reopcitry.save(user).getUid();
	}

	@Override
	public Optional<User> getOneUser(Integer id) {
		// TODO Auto-generated method stub
		return reopcitry.findById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	Optional<User>opt=reopcitry.findByUserEmail(username);
	if(opt.isEmpty()) {
		throw new UsernameNotFoundException(username+"not fount");
	}
	User user=opt.get();
	List<GrantedAuthority> authorities=user.getUserRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	return new org.springframework.security.core.userdetails.User(username,user.getUserPassword(),authorities);
	}

}
