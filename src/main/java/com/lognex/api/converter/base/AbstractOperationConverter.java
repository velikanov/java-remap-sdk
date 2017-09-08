package com.lognex.api.converter.base;

import com.fasterxml.jackson.databind.JsonNode;
import com.lognex.api.exception.ConverterException;
import com.lognex.api.model.base.AbstractOperation;
import com.lognex.api.util.DateParser;

public abstract class AbstractOperationConverter extends AbstractEntityLegendableConverter {
    protected void convertToEntity(final AbstractOperation entity, JsonNode node) throws ConverterException {
        super.convertToEntity(entity, node);
        entity.setMoment(DateParser.parseDate(node.get("moment").asText()));
        entity.setApplicable(node.get("applicable").asBoolean());
        entity.setSum(node.get("sum").asDouble());
        entity.setSyncId(node.get("syncId") == null ? null : node.get("syncId").asText());
    }
}
