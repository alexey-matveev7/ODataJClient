package com.msopentech.odatajclient.proxy.defaultservice.microsoft.test.odata.services.astoriadefaultservice.types;

import com.msopentech.odatajclient.proxy.api.annotations.ComplexType;
import com.msopentech.odatajclient.proxy.api.annotations.Property;
import com.msopentech.odatajclient.proxy.api.AbstractComplexType;
import com.msopentech.odatajclient.proxy.defaultservice.microsoft.test.odata.services.astoriadefaultservice.*;
import com.msopentech.odatajclient.proxy.defaultservice.microsoft.test.odata.services.astoriadefaultservice.types.*;

// EdmSimpleType property imports
import com.msopentech.odatajclient.engine.data.ODataDuration;
import com.msopentech.odatajclient.engine.data.ODataTimestamp;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.Geospatial;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.GeospatialCollection;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.LineString;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.MultiLineString;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.MultiPoint;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.MultiPolygon;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.Point;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.Polygon;
import java.math.BigDecimal;
import java.net.URI;
import java.util.UUID;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Collection;

@ComplexType("ConcurrencyInfo")
public class ConcurrencyInfo extends AbstractComplexType {

    private String _token;

    @Property(name = "Token", type = "Edm.String", nullable = true)
    public String getToken() {
        return _token;
    }

    public void setToken(final String _token) {
        this._token = _token;
    }
    private ODataTimestamp _queriedDateTime;

    @Property(name = "QueriedDateTime", type = "Edm.DateTime", nullable = true)
    public ODataTimestamp getQueriedDateTime() {
        return _queriedDateTime;
    }

    public void setQueriedDateTime(final ODataTimestamp _queriedDateTime) {
        this._queriedDateTime = _queriedDateTime;
    }
}