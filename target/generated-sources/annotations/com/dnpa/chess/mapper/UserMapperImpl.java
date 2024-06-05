package com.dnpa.chess.mapper;

import com.dnpa.chess.dto.GameDto;
import com.dnpa.chess.dto.SignInDto;
import com.dnpa.chess.dto.SignUpDto;
import com.dnpa.chess.entity.Game;
import com.dnpa.chess.entity.Game.GameBuilder;
import com.dnpa.chess.entity.User;
import com.dnpa.chess.entity.User.UserBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T10:45:48+0700",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User map(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.email( signUpDto.getEmail() );
        user.gioiTinh( signUpDto.isGioiTinh() );
        user.hoTen( signUpDto.getHoTen() );
        user.id( signUpDto.getId() );
        user.password( signUpDto.getPassword() );
        user.soDienThoai( signUpDto.getSoDienThoai() );
        user.username( signUpDto.getUsername() );

        return user.build();
    }

    @Override
    public User map(SignInDto signInDto) {
        if ( signInDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.password( signInDto.getPassword() );
        user.username( signInDto.getUsername() );

        return user.build();
    }

    @Override
    public Game map(GameDto gameDto) {
        if ( gameDto == null ) {
            return null;
        }

        GameBuilder game = Game.builder();

        game.id( gameDto.getId() );
        game.move( gameDto.getMove() );
        game.playerSide( gameDto.getPlayerSide() );
        game.result( gameDto.getResult() );
        game.winner( gameDto.getWinner() );

        return game.build();
    }
}
