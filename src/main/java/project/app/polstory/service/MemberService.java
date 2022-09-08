package project.app.polstory.service;

import project.app.polstory.dto.UserDTO;
import project.app.polstory.entity.User;

public interface MemberService {

    void MemberSave(UserDTO dto);

    default User dtoToEntity(UserDTO dto){
       User entity = User.builder()
                .userNick(dto.getUserNick())
                .userId(dto.getUserId())
                .userPassword(dto.getUserPassword())
                .userEmail(dto.getUserEmail())
                .userName(dto.getUserName())
                .userIdx(dto.getUserIdx())
                .build();

        return entity;
    }

    default UserDTO entityToDTO(User entity){
        UserDTO DTO = UserDTO.builder()
                .userId(entity.getUserId())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .userEmail(entity.getUserEmail())
                .userIdx(entity.getUserIdx())
                .userName(entity.getUserName())
                .userNick(entity.getUserNick())
                .userPassword(entity.getUserPassword())
                .build();

        return DTO;
    }

}
