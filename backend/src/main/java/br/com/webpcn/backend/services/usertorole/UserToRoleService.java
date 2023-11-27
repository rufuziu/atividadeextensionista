package br.com.webpcn.backend.services.usertorole;

import br.com.webpcn.backend.dtos.UserDTO;
import br.com.webpcn.backend.dtos.UserToRoleDTO;
import br.com.webpcn.backend.entities.user.UserToRole;
import br.com.webpcn.backend.exceptions.usertorole.UserToRoleException;
import br.com.webpcn.backend.repositories.usertorole.UserToRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserToRoleService {
  @Autowired
  UserToRoleRepository userToRoleRepository;
  @Autowired
  ModelMapper modelMapper;
  public UserDTO bindUserToRole(UserDTO userDTO) {
    UserToRole userToRoleSaved = userToRoleRepository.save(
            modelMapper.map(
                    new UserToRoleDTO(userDTO.getId(), userDTO.getRoleId()),
                    UserToRole.class
            )
    );
    if(userToRoleSaved == null)
      throw new UserToRoleException("Error to bind User to Role");
    else return userDTO;
  }
}
