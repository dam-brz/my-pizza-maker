package com.dambrz.pizza.maker.calculation;

import com.dambrz.pizza.maker.model.Size;

import java.util.Map;
import java.util.Optional;

import static com.dambrz.pizza.maker.model.Size.*;

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
