package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.ReceiptsList;

import java.util.Collection;
import java.util.Set;

/**
 * @author arman.shamenov
 */
public class GetReceiptsQuery extends DreamkasQuery<ReceiptsList> {

    private QueryParam<String> from;
    private QueryParam<String> to;
    private QueryParam<Long> limit;
    private QueryParam<Long> offset;
    private QueryParam<Collection<String>> devicesIds;

    public GetReceiptsQuery(DreamkasClient client) {
        super(client, "/receipts", null, ReceiptsList.class, DreamkasTransportClient.Method.GET);
    }

    public GetReceiptsQuery from(String from) {
        if (this.from == null) {
            this.from = new QueryParam<>("from", this);
        }
        this.from.setValue(from);
        return this;
    }

    public GetReceiptsQuery to(String to) {
        if (this.to == null) {
            this.to = new QueryParam<>("to", this);
        }
        this.to.setValue(to);
        return this;
    }

    public GetReceiptsQuery limit(Long limit) {
        if (this.limit == null) {
            this.limit = new QueryParam<>("limit", this);
        }
        this.limit.setValue(limit);
        return this;
    }

    public GetReceiptsQuery offset(Long offset) {
        if (this.offset == null) {
            this.offset = new QueryParam<>("offset", this);
        }
        this.offset.setValue(offset);
        return this;
    }

    public GetReceiptsQuery devices(Set<String> devicesIds) {
        if (this.devicesIds == null) {
            this.devicesIds = new CollectionQueryParam<>("devices", this);
        }
        this.devicesIds.setValue(devicesIds);
        return this;
    }
}
