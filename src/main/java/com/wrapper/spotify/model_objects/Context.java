package com.wrapper.spotify.model_objects;

import com.google.gson.JsonObject;

/**
 * Retrieve information about Context objects by building instances from this class.
 * Context objects contain information from where a specific track has been played by a user.
 */
public class Context extends AbstractModelObject {
  private final ModelObjectType type;
  private final String href;
  private final ExternalUrls externalUrls;
  private final String uri;

  private Context(final Context.Builder builder) {
    super(builder);

    this.type = builder.type;
    this.href = builder.href;
    this.externalUrls = builder.externalUrls;
    this.uri = builder.uri;
  }

  /**
   * Get the model object type of the context.
   *
   * @return The object type, e.g. &quot;artist&quot;, &quot;playlist&quot;, &quot;album&quot;.
   */
  public ModelObjectType getType() {
    return type;
  }

  /**
   * Get the href of the contexts track.
   *
   * @return A link to the Web API endpoint providing full details of the track.
   */
  public String getHref() {
    return href;
  }

  /**
   * Get the external urls of the context.
   *
   * @return External URLs for this context.
   */
  public ExternalUrls getExternalUrls() {
    return externalUrls;
  }

  /**
   * Get the Spotify URI for the context.
   *
   * @return The Spotify URI for the context.
   */
  public String getUri() {
    return uri;
  }

  @Override
  public Builder builder() {
    return new Builder();
  }

  /**
   * Builder class for building Context instances.
   */
  public static final class Builder extends AbstractModelObject.Builder {
    private ModelObjectType type;
    private String href;
    private ExternalUrls externalUrls;
    private String uri;

    /**
     * The model object type setter.
     *
     * @param type The object type, e.g. &quot;artist&quot;, &quot;playlist&quot;, &quot;album&quot;.
     * @return A Context builder.
     */
    public Builder setType(ModelObjectType type) {
      this.type = type;
      return this;
    }

    /**
     * The context href setter.
     *
     * @param href A link to the Web API endpoint providing full details of the track.
     * @return A Context builder.
     */
    public Builder setHref(String href) {
      this.href = href;
      return this;
    }

    /**
     * The external urls setter.
     *
     * @param externalUrls External URLs for this context.
     * @return A Context builder.
     */
    public Builder setExternalUrls(ExternalUrls externalUrls) {
      this.externalUrls = externalUrls;
      return this;
    }

    /**
     * The external urls setter.
     *
     * @param uri External URLs for this context.
     * @return A Context builder.
     */
    public Builder setUri(String uri) {
      this.uri = uri;
      return this;
    }

    @Override
    public Context build() {
      return new Context(this);
    }
  }

  /**
   * JsonUtil class for building Context instances.
   */
  public static final class JsonUtil extends AbstractModelObject.JsonUtil<Context> {
    public Context createModelObject(JsonObject jsonObject) {
      if (jsonObject == null || jsonObject.isJsonNull()) {
        return null;
      }

      return new Context.Builder()
              .setType(ModelObjectType.valueOf(jsonObject.get("type").getAsString().toUpperCase()))
              .setHref(jsonObject.get("href").getAsString())
              .setExternalUrls(new ExternalUrls.JsonUtil().createModelObject(jsonObject.getAsJsonObject("external_urls")))
              .setUri(jsonObject.get("uri").getAsString())
              .build();
    }
  }
}
