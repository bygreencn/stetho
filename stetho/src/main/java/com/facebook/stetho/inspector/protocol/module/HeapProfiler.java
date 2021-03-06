// Copyright 2004-present Facebook. All Rights Reserved.

package com.facebook.stetho.inspector.protocol.module;

import java.util.Collections;
import java.util.List;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;

import com.facebook.stetho.json.annotation.JsonProperty;
import org.json.JSONObject;

public class HeapProfiler implements ChromeDevtoolsDomain {
  public HeapProfiler() {
  }

  @ChromeDevtoolsMethod
  public JsonRpcResult getProfileHeaders(JsonRpcPeer peer, JSONObject params) {
    ProfileHeaderResponse response = new ProfileHeaderResponse();
    response.headers = Collections.emptyList();
    return response;
  }

  private static class ProfileHeaderResponse implements JsonRpcResult {
    @JsonProperty(required = true)
    public List<ProfileHeader> headers;
  }

  private static class ProfileHeader {
    @JsonProperty(required = true)
    public String title;

    @JsonProperty(required = true)
    public int uid;
  }
}
