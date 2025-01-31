package it.polimi.mymoto.state.definition.order;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderContext {
    private OrderState state;

    public void updateState(OrderContext context) {
        state.updateState(context);
    }
}
