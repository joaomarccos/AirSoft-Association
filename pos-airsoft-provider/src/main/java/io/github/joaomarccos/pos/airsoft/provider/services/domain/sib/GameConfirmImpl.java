package io.github.joaomarccos.pos.airsoft.provider.services.domain.sib;

import io.github.joaomarccos.pos.airsoft.provider.services.sei.GameConfirm;
import io.github.joaomarccos.pos.airsoft.services.InvitationPlayerService;
import javax.jws.WebService;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@WebService(endpointInterface = "io.github.joaomarccos.pos.airsoft.provider.services.sei.GameConfirm")
public class GameConfirmImpl implements GameConfirm {

    @Override
    public boolean confirmParticipation(String token) {
        InvitationPlayerService ips = new InvitationPlayerService();
        boolean confirmInvitation = ips.confirmInvitation(token);
        return confirmInvitation;
    }

}
