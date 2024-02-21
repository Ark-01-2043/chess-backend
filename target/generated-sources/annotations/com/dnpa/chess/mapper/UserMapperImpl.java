package com.dnpa.chess.mapper;

import com.dnpa.chess.dto.GameDto;
import com.dnpa.chess.dto.SignInDto;
import com.dnpa.chess.dto.SignUpDto;
import com.dnpa.chess.entity.Game;
import com.dnpa.chess.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T19:41:21+0700",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User map(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        User user = new User();

        user.setHoTen( signUpDto.getHoTen() );
        user.setUsername( signUpDto.getUsername() );
        user.setPassword( signUpDto.getPassword() );
        user.setEmail( signUpDto.getEmail() );
        user.setSoDienThoai( signUpDto.getSoDienThoai() );
        user.setGioiTinh( signUpDto.isGioiTinh() );

        return user;
    }

    @Override
    public User map(SignInDto signInDto) {
        if ( signInDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( signInDto.getUsername() );
        user.setPassword( signInDto.getPassword() );

        return user;
    }

    @Override
    public Game map(GameDto gameDto) {
        if ( gameDto == null ) {
            return null;
        }

        Game game = new Game();

        game.setId( gameDto.getId() );
        game.setPlayerSide( gameDto.getPlayerSide() );
        game.setWinner( gameDto.getWinner() );
        game.setResult( gameDto.getResult() );
        game.setMove( gameDto.getMove() );

        return game;
    }
}
