package io.qiot.manufacturing.datacenter.commons.util.producer;

import java.time.Instant;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import io.qiot.manufacturing.all.commons.domain.productline.ColorRangesDTO;
import io.qiot.manufacturing.all.commons.domain.productline.PackagingRangesDTO;
import io.qiot.manufacturing.all.commons.domain.productline.PrintingRangesDTO;
import io.qiot.manufacturing.all.commons.domain.productline.SizeChartRangesDTO;
import io.qiot.manufacturing.datacenter.commons.domain.productline.GlobalProductLineDTO;
import io.qiot.manufacturing.datacenter.commons.domain.productline.MarginsDTO;

/**
 * @author andreabattaglia
 *
 */
@ApplicationScoped
public class SampleGlobalProductLineProducer {

    public GlobalProductLineDTO generate() {
        GlobalProductLineDTO pl = new GlobalProductLineDTO();

        pl.id = UUID.randomUUID();

        pl.sizeChart = size();

        pl.color = color();

        pl.print = printing();

        pl.packaging = packaging();

        pl.createdOn = Instant.now();

        pl.margins = margins();

        pl.active = true;

        return pl;
    }

    private SizeChartRangesDTO size() {
        SizeChartRangesDTO sizeChart = new SizeChartRangesDTO();
        sizeChart.chestMin = 21.5;
        sizeChart.chestMax = 23;
        sizeChart.shoulderMin = 17.5;
        sizeChart.shoulderMax = 18.5;
        sizeChart.backMin = 27.5;
        sizeChart.backMax = 28.5;
        sizeChart.waistMin = 21.5;
        sizeChart.waistMax = 22.5;
        sizeChart.hipMin = 21;
        sizeChart.hipMax = 22;
        return sizeChart;
    }

    private ColorRangesDTO color() {
        ColorRangesDTO color = new ColorRangesDTO();
        color.redMin = 250;
        color.redMax = 255;
        color.greenMin = 0;
        color.greenMax = 5;
        color.blueMin = 0;
        color.blueMax = 5;
        return color;
    }

    private PrintingRangesDTO printing() {
        PrintingRangesDTO printing = new PrintingRangesDTO();
        printing.min = 0.1;
        printing.max = 0.9;
        return printing;
    }

    private PackagingRangesDTO packaging() {
        PackagingRangesDTO packaging = new PackagingRangesDTO();
        packaging.min = 0.2;
        packaging.max = 0.8;
        return packaging;
    }

    private MarginsDTO margins() {
        MarginsDTO margins = new MarginsDTO();
        margins.weaving = 0.01;
        margins.coloring = 1;
        margins.printing = 0.001;
        margins.packaging = 0.001;
        return margins;
    }
}
