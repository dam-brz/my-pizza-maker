package com.dambrz.pizza.maker;

import java.util.Map;
import java.util.Optional;

import static com.dambrz.pizza.maker.Size.*;

public class MapCalculationStrategyResolver implements CalculationStrategyResolver {

    private static final Map<Size, CalculationStrategy> CALCULATORS = Map.of(
            SMALL, new SmallPizzaCalculationStrategy(),
            MEDIUM, new MediumPizzaCalculationStrategy(),
            LARGE, new LargePizzaCalculationStrategy(),
            EXTRA_LARGE, new ExtraLargePizzaCalculationStrategy()
    );

    @Override
    public CalculationStrategy chooseStrategy(Size size) {
        return Optional.ofNullable(CALCULATORS.get(size))
                .orElseThrow(() -> new IllegalStateException("Unknown pizza size=" + size));
    }
}
