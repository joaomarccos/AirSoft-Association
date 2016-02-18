package io.github.joaomarccos.pos.airsoft.repositories.interfaces;

import io.github.joaomarccos.pos.airsoft.entitys.GameInvitation;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public interface GameInvitationRepository extends Repository<GameInvitation>{
    public GameInvitation findByToken(String token);
}
