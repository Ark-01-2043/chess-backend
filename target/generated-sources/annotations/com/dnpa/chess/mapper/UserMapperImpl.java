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
    date = "2024-02-20T18:11:26+0700",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User map(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( signUpDto.getEmail() );
        user.setGioiTinh( signUpDto.isGioiTinh() );
        user.setHoTen( signUpDto.getHoTen() );
        user.setPassword( signUpDto.getPassword() );
        user.setSoDienThoai( signUpDto.getSoDienThoai() );
        user.setUsername( signUpDto.getUsername() );

        return user;
    }

    @Override
    public User map(SignInDto signInDto) {
        if ( signInDto == null ) {
            return null;
        }

        User user = new User();

        user.setPassword( signInDto.getPassword() );
        user.setUsername( signInDto.getUsername() );

        return user;
    }

    @Override
    public Game map(GameDto gameDto) {
        if ( gameDto == null ) {
            return null;
        }

        Game game = new Game();

        game.setId( gameDto.getId() );
        game.setMove( gameDto.getMove() );
        game.setPlayerSide( gameDto.getPlayerSide() );
        game.setResult( gameDto.getResult() );
        game.setWinner( gameDto.getWinner() );

        return game;
    }
}
