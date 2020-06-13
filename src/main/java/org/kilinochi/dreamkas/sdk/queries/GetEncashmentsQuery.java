package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.EncashmentsList;

import java.util.Collection;
import java.util.Set;

/**
 * @author arman.shamenov
 */
public class GetEncashmentsQuery extends DreamkasQuery<EncashmentsList> {
    private QueryParam<String> from;
    private QueryParam<String> to;
    private QueryParam<Long> limit;
    private QueryParam<Long> offset;
    private QueryParam<Collection<String>> devicesIds;

    public GetEncashmentsQuery(DreamkasClient client) {
        super(client, "/encashments", null, EncashmentsList.class, DreamkasTransportClient.Method.GET);
    }

    public GetEncashmentsQuery from(String from) {
        if (this.from == null) {
            this.from = new QueryParam<>("from", this);
        }
        this.from.setValue(from);
        return this;
    }

    public GetEncashmentsQuery to(String to) {
        if (this.to == null) {
            this.to = new QueryParam<>("to", this);
        }
        this.to.setValue(to);
        return this;
    }

    public GetEncashmentsQuery limit(Long limit) {
        if (this.limit == null) {
            this.limit = new QueryParam<>("limit", this);
        }
        this.limit.setValue(limit);
        return this;
    }

    public GetEncashmentsQuery offset(Long offset) {
        if (this.offset == null) {
            this.offset = new QueryParam<>("offset", this);
        }
        this.offset.setValue(offset);
        return this;
    }

    public GetEncashmentsQuery devices(Set<String> devicesIds) {
        if (this.devicesIds == null) {
            this.devicesIds = new CollectionQueryParam<>("devices", this);
        }
        this.devicesIds.setValue(devicesIds);
        return this;
    }
}
