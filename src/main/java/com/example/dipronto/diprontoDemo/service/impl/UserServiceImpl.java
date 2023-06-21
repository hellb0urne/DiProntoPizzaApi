package com.example.dipronto.diprontoDemo.service.impl;

import com.example.dipronto.diprontoDemo.entity.User;
import com.example.dipronto.diprontoDemo.exception.InvalidRoleException;
import com.example.dipronto.diprontoDemo.exception.NullRoleException;
import com.example.dipronto.diprontoDemo.exception.UserExistException;
import com.example.dipronto.diprontoDemo.repository.DaoUser;
import com.example.dipronto.diprontoDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final DaoUser daoUser;

    @Override
    public User addUser(User user) {
        validateUserExistence(user);
        validateUserRole(user);
        daoUser.save(user);
        return user;
    }

    private void validateUserExistence(User user) {
        var userName = daoUser.findByNombre(user.getNombre());
        if (userName != null) {
            throw new UserExistException("El usuario ya existe");
        }
    }


    private void validateUserRole(User user) {
        if (user.getRole() == null) {
            throw new NullRoleException("El campo 'rol' no puede ser nulo");
        } else if (!isValidRole(user.getRole())) {
            throw new InvalidRoleException("El campo 'rol' tiene un valor inválido");
        }
    }

    private boolean isValidRole(User.Rol rol) {
        return rol == User.Rol.ADMIN || rol == User.Rol.USER;
    }
}
