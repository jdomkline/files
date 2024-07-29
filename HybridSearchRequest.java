package opensearch;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.ScriptField;
import org.opensearch.client.opensearch._types.SearchType;
import org.opensearch.client.opensearch._types.SlicedScroll;
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.aggregations.Aggregation;
import org.opensearch.client.opensearch._types.mapping.RuntimeField;
import org.opensearch.client.opensearch._types.query_dsl.FieldAndFormat;
import org.opensearch.client.opensearch._types.query_dsl.Operator;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.search.FieldCollapse;
import org.opensearch.client.opensearch.core.search.Highlight;
import org.opensearch.client.opensearch.core.search.Pit;
import org.opensearch.client.opensearch.core.search.Rescore;
import org.opensearch.client.opensearch.core.search.SourceConfig;
import org.opensearch.client.opensearch.core.search.Suggester;
import org.opensearch.client.opensearch.core.search.TrackHits;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _global.search.Request

/**
 * Returns results matching a query.
 */
@JsonpDeserializable
public class HybridSearchRequest extends RequestBase implements JsonpSerializable {
  /**
   * Json deserializer for {@link HybridSearchRequest}.
   */
  public static final JsonpDeserializer<HybridSearchRequest> _DESERIALIZER =
      ObjectBuilderDeserializer.lazy(
          HybridSearchRequest.Builder::new,
          HybridSearchRequest::setupSearchRequestDeserializer
      );
  /**
   * Endpoint "{@code search}".
   */
  public static final SimpleEndpoint<HybridSearchRequest, ?> _ENDPOINT = new SimpleEndpoint<>(

      // Request method
      request -> {
        return "POST";
      },

      // Request path
      request -> {
        final int _index = 1 << 0;

        int propsSet = 0;

        if (ApiTypeHelper.isDefined(request.index())) {
          propsSet |= _index;
        }

        if (propsSet == 0) {
          return "/_search";
        }
        if (propsSet == (_index)) {
          StringBuilder buf = new StringBuilder();
          buf.append("/");
          SimpleEndpoint.pathEncode(
              request.index.stream().map(v -> v).collect(Collectors.joining(",")), buf);
          buf.append("/_search");
          return buf.toString();
        }
        throw SimpleEndpoint.noPathTemplateFound("path");

      },

      // Request parameters
      request -> {
        Map<String, String> params = new HashMap<>();
        params.put("typed_keys", "true");
        if (request.df != null) {
          params.put("df", request.df);
        }
        if (request.preFilterShardSize != null) {
          params.put("pre_filter_shard_size", String.valueOf(request.preFilterShardSize));
        }
        if (request.minCompatibleShardNode != null) {
          params.put("min_compatible_shard_node", request.minCompatibleShardNode);
        }
        if (request.lenient != null) {
          params.put("lenient", String.valueOf(request.lenient));
        }
        if (request.routing != null) {
          params.put("routing", request.routing);
        }
        if (request.ignoreUnavailable != null) {
          params.put("ignore_unavailable", String.valueOf(request.ignoreUnavailable));
        }
        if (request.allowNoIndices != null) {
          params.put("allow_no_indices", String.valueOf(request.allowNoIndices));
        }
        if (request.analyzer != null) {
          params.put("analyzer", request.analyzer);
        }
        if (request.ignoreThrottled != null) {
          params.put("ignore_throttled", String.valueOf(request.ignoreThrottled));
        }
        if (request.maxConcurrentShardRequests != null) {
          params.put("max_concurrent_shard_requests",
              String.valueOf(request.maxConcurrentShardRequests));
        }
        if (request.allowPartialSearchResults != null) {
          params.put("allow_partial_search_results",
              String.valueOf(request.allowPartialSearchResults));
        }
        if (ApiTypeHelper.isDefined(request.expandWildcards)) {
          params.put("expand_wildcards", request.expandWildcards.stream().map(v -> v.jsonValue())
              .collect(Collectors.joining(",")));
        }
        if (request.preference != null) {
          params.put("preference", request.preference);
        }
        if (request.analyzeWildcard != null) {
          params.put("analyze_wildcard", String.valueOf(request.analyzeWildcard));
        }
        if (request.scroll != null) {
          params.put("scroll", request.scroll._toJsonString());
        }
        if (request.searchType != null) {
          params.put("search_type", request.searchType.jsonValue());
        }
        if (request.ccsMinimizeRoundtrips != null) {
          params.put("ccs_minimize_roundtrips", String.valueOf(request.ccsMinimizeRoundtrips));
        }
        if (request.qcheckStyled != null) {
          params.put("q", request.qcheckStyled);
        }
        if (request.defaultOperator != null) {
          params.put("default_operator", request.defaultOperator.jsonValue());
        }
        if (request.requestCache != null) {
          params.put("request_cache", String.valueOf(request.requestCache));
        }
        if (request.batchedReduceSize != null) {
          params.put("batched_reduce_size", String.valueOf(request.batchedReduceSize));
        }
        if (request.searchPipeline != null) {
          params.put("search_pipeline", request.searchPipeline);
        }
        return params;

      },
      SimpleEndpoint.emptyMap(),
      true,
      SearchResponse._DESERIALIZER
  );
  @Nullable
  private final SourceConfig source;
  private final Map<String, Aggregation> aggregations;
  @Nullable
  private final Boolean allowNoIndices;
  @Nullable
  private final Boolean allowPartialSearchResults;
  @Nullable
  private final Boolean analyzeWildcard;
  @Nullable
  private final String analyzer;
  @Nullable
  private final Long batchedReduceSize;
  @Nullable
  private final Boolean ccsMinimizeRoundtrips;
  @Nullable
  private final FieldCollapse collapse;
  @Nullable
  private final Operator defaultOperator;
  @Nullable
  private final String df;
  private final List<FieldAndFormat> docvalueFields;
  private final List<ExpandWildcard> expandWildcards;
  @Nullable
  private final Boolean explain;
  private final List<FieldAndFormat> fields;
  @Nullable
  private final Integer from;
  @Nullable
  private final Highlight highlight;
  @Nullable
  private final Boolean ignoreThrottled;
  @Nullable
  private final Boolean ignoreUnavailable;
  private final List<String> index;
  private final List<Map<String, Double>> indicesBoost;
  @Nullable
  private final Boolean lenient;
  @Nullable
  private final Long maxConcurrentShardRequests;
  @Nullable
  private final String minCompatibleShardNode;
  @Nullable
  private final Double minScore;
  @Nullable
  private final Pit pit;
  @Nullable
  private final Query postFilter;
  @Nullable
  private final Long preFilterShardSize;
  @Nullable
  private final String preference;
  @Nullable
  private final Boolean profile;
  @Nullable
  @SuppressWarnings("all")
  private final String qcheckStyled;
  @Nullable
  private final Query query;
  @Nullable
  private final Boolean requestCache;
  private final List<Rescore> rescore;
  @Nullable
  private final String routing;
  private final Map<String, RuntimeField> runtimeMappings;
  private final Map<String, ScriptField> scriptFields;
  @Nullable
  private final Time scroll;
  private final List<FieldValue> searchAfter;
  @Nullable
  private final SearchType searchType;
  @Nullable
  private final Boolean seqNoPrimaryTerm;
  @Nullable
  private final Integer size;
  @Nullable
  private final SlicedScroll slice;
  private final List<SortOptions> sort;
  private final List<String> stats;
  private final List<String> storedFields;
  @Nullable
  private final Suggester suggest;
  @Nullable
  private final Long terminateAfter;
  @Nullable
  private final String timeout;
  @Nullable
  private final Boolean trackScores;
  @Nullable
  private final TrackHits trackTotalHits;
  @Nullable
  private final Boolean version;

  // ---------------------------------------------------------------------------------------------
  private final Map<String, JsonData> ext;
  @Nullable
  private final String searchPipeline;

  private HybridSearchRequest(Builder builder) {

    this.source = builder.source;
    this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);
    this.allowNoIndices = builder.allowNoIndices;
    this.allowPartialSearchResults = builder.allowPartialSearchResults;
    this.analyzeWildcard = builder.analyzeWildcard;
    this.analyzer = builder.analyzer;
    this.batchedReduceSize = builder.batchedReduceSize;
    this.ccsMinimizeRoundtrips = builder.ccsMinimizeRoundtrips;
    this.collapse = builder.collapse;
    this.defaultOperator = builder.defaultOperator;
    this.df = builder.df;
    this.docvalueFields = ApiTypeHelper.unmodifiable(builder.docvalueFields);
    this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
    this.explain = builder.explain;
    this.fields = ApiTypeHelper.unmodifiable(builder.fields);
    this.from = builder.from;
    this.highlight = builder.highlight;
    this.ignoreThrottled = builder.ignoreThrottled;
    this.ignoreUnavailable = builder.ignoreUnavailable;
    this.index = ApiTypeHelper.unmodifiable(builder.index);
    this.indicesBoost = ApiTypeHelper.unmodifiable(builder.indicesBoost);
    this.lenient = builder.lenient;
    this.maxConcurrentShardRequests = builder.maxConcurrentShardRequests;
    this.minCompatibleShardNode = builder.minCompatibleShardNode;
    this.minScore = builder.minScore;
    this.pit = builder.pit;
    this.postFilter = builder.postFilter;
    this.preFilterShardSize = builder.preFilterShardSize;
    this.preference = builder.preference;
    this.profile = builder.profile;
    this.qcheckStyled
        = builder.qcheckStyled
    ;
    this.query = builder.query;
    this.requestCache = builder.requestCache;
    this.rescore = ApiTypeHelper.unmodifiable(builder.rescore);
    this.routing = builder.routing;
    this.runtimeMappings = ApiTypeHelper.unmodifiable(builder.runtimeMappings);
    this.scriptFields = ApiTypeHelper.unmodifiable(builder.scriptFields);
    this.scroll = builder.scroll;
    this.searchAfter = ApiTypeHelper.unmodifiable(builder.searchAfter);
    this.searchType = builder.searchType;
    this.seqNoPrimaryTerm = builder.seqNoPrimaryTerm;
    this.size = builder.size;
    this.slice = builder.slice;
    this.sort = ApiTypeHelper.unmodifiable(builder.sort);
    this.stats = ApiTypeHelper.unmodifiable(builder.stats);
    this.storedFields = ApiTypeHelper.unmodifiable(builder.storedFields);
    this.suggest = builder.suggest;
    this.terminateAfter = builder.terminateAfter;
    this.timeout = builder.timeout;
    this.trackScores = builder.trackScores;
    this.trackTotalHits = builder.trackTotalHits;
    this.version = builder.version;
    this.ext = ApiTypeHelper.unmodifiable(builder.ext);
    this.searchPipeline = builder.searchPipeline;

  }

  public static HybridSearchRequest of(
      Function<HybridSearchRequest.Builder, ObjectBuilder<HybridSearchRequest>> fn) {
    return fn.apply(new HybridSearchRequest.Builder()).build();
  }

  protected static void setupSearchRequestDeserializer(
      ObjectDeserializer<HybridSearchRequest.Builder> op) {

    op.add(HybridSearchRequest.Builder::source, SourceConfig._DESERIALIZER, "_source");
    op.add(HybridSearchRequest.Builder::aggregations,
        JsonpDeserializer.stringMapDeserializer(Aggregation._DESERIALIZER), "aggregations",
        "aggs");
    op.add(HybridSearchRequest.Builder::collapse, FieldCollapse._DESERIALIZER, "collapse");
    op.add(HybridSearchRequest.Builder::docvalueFields,
        JsonpDeserializer.arrayDeserializer(FieldAndFormat._DESERIALIZER), "docvalue_fields");
    op.add(HybridSearchRequest.Builder::explain, JsonpDeserializer.booleanDeserializer(),
        "explain");
    op.add(HybridSearchRequest.Builder::fields,
        JsonpDeserializer.arrayDeserializer(FieldAndFormat._DESERIALIZER), "fields");
    op.add(HybridSearchRequest.Builder::from, JsonpDeserializer.integerDeserializer(), "from");
    op.add(HybridSearchRequest.Builder::highlight, Highlight._DESERIALIZER, "highlight");
    op.add(
        HybridSearchRequest.Builder::indicesBoost,
        JsonpDeserializer.arrayDeserializer(
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.doubleDeserializer())),
        "indices_boost"
    );
    op.add(HybridSearchRequest.Builder::minScore, JsonpDeserializer.doubleDeserializer(),
        "min_score");
    op.add(HybridSearchRequest.Builder::pit, Pit._DESERIALIZER, "pit");
    op.add(HybridSearchRequest.Builder::postFilter, Query._DESERIALIZER, "post_filter");
    op.add(HybridSearchRequest.Builder::profile, JsonpDeserializer.booleanDeserializer(),
        "profile");
    op.add(HybridSearchRequest.Builder::query, Query._DESERIALIZER, "query");
    op.add(HybridSearchRequest.Builder::rescore,
        JsonpDeserializer.arrayDeserializer(Rescore._DESERIALIZER), "rescore");
    op.add(HybridSearchRequest.Builder::runtimeMappings,
        JsonpDeserializer.stringMapDeserializer(RuntimeField._DESERIALIZER), "runtime_mappings");
    op.add(HybridSearchRequest.Builder::scriptFields,
        JsonpDeserializer.stringMapDeserializer(ScriptField._DESERIALIZER), "script_fields");
    op.add(HybridSearchRequest.Builder::searchAfter,
        JsonpDeserializer.arrayDeserializer(FieldValue._DESERIALIZER), "search_after");
    op.add(HybridSearchRequest.Builder::seqNoPrimaryTerm, JsonpDeserializer.booleanDeserializer(),
        "seq_no_primary_term");
    op.add(HybridSearchRequest.Builder::size, JsonpDeserializer.integerDeserializer(), "size");
    op.add(HybridSearchRequest.Builder::slice, SlicedScroll._DESERIALIZER, "slice");
    op.add(HybridSearchRequest.Builder::sort,
        JsonpDeserializer.arrayDeserializer(SortOptions._DESERIALIZER), "sort");
    op.add(HybridSearchRequest.Builder::stats,
        JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stats");
    op.add(HybridSearchRequest.Builder::storedFields,
        JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
        "stored_fields");
    op.add(HybridSearchRequest.Builder::suggest, Suggester._DESERIALIZER, "suggest");
    op.add(HybridSearchRequest.Builder::terminateAfter, JsonpDeserializer.longDeserializer(),
        "terminate_after");
    op.add(HybridSearchRequest.Builder::timeout, JsonpDeserializer.stringDeserializer(), "timeout");
    op.add(HybridSearchRequest.Builder::trackScores, JsonpDeserializer.booleanDeserializer(),
        "track_scores");
    op.add(HybridSearchRequest.Builder::trackTotalHits, TrackHits._DESERIALIZER,
        "track_total_hits");
    op.add(HybridSearchRequest.Builder::version, JsonpDeserializer.booleanDeserializer(),
        "version");
    op.add(HybridSearchRequest.Builder::ext,
        JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "ext");

  }

  /**
   * Create an "{@code search}" endpoint.
   */
  public static <T> Endpoint<HybridSearchRequest, SearchResponse<T>, ErrorResponse>
      createSearchEndpoint(
      JsonpDeserializer<T> tdocumentDeserializer
  ) {
    return _ENDPOINT.withResponseDeserializer(
        SearchResponse.createSearchResponseDeserializer(tdocumentDeserializer));
  }

  /**
   * Indicates which source fields are returned for matching documents. These
   * fields are returned in the hits._source property of the search response.
   * API name: {@code _source}
   */
  @Nullable
  public final SourceConfig source() {
    return this.source;
  }

  /**
   * API name: {@code aggregations}.
   */
  public final Map<String, Aggregation> aggregations() {
    return this.aggregations;
  }

  /**
   * Whether to ignore if a wildcard indices expression resolves into no concrete
   * indices. (This includes <code>_all</code> string or when no indices have been
   * specified).
   * API name: {@code allow_no_indices}
   */
  @Nullable
  public final Boolean allowNoIndices() {
    return this.allowNoIndices;
  }

  /**
   * Indicate if an error should be returned if there is a partial search failure
   * or timeout.
   * API name: {@code allow_partial_search_results}
   */
  @Nullable
  public final Boolean allowPartialSearchResults() {
    return this.allowPartialSearchResults;
  }

  /**
   * Specify whether wildcard and prefix queries should be analyzed (default:
   * false).
   * API name: {@code analyze_wildcard}
   */
  @Nullable
  public final Boolean analyzeWildcard() {
    return this.analyzeWildcard;
  }

  /**
   * The analyzer to use for the query string.
   * API name: {@code analyzer}
   */
  @Nullable
  public final String analyzer() {
    return this.analyzer;
  }

  /**
   * The number of shard results that should be reduced at once on the
   * coordinating node. This value should be used as a protection mechanism to
   * reduce the memory overhead per search request if the potential number of
   * shards in the request can be large.
   * API name: {@code batched_reduce_size}
   */
  @Nullable
  public final Long batchedReduceSize() {
    return this.batchedReduceSize;
  }

  /**
   * Indicates whether network round-trips should be minimized as part of
   * cross-cluster search requests execution.
   * API name: {@code ccs_minimize_roundtrips}
   */
  @Nullable
  public final Boolean ccsMinimizeRoundtrips() {
    return this.ccsMinimizeRoundtrips;
  }

  /**
   * API name: {@code collapse}.
   */
  @Nullable
  public final FieldCollapse collapse() {
    return this.collapse;
  }

  /**
   * The default operator for query string query (AND or OR).
   * API name: {@code default_operator}
   */
  @Nullable
  public final Operator defaultOperator() {
    return this.defaultOperator;
  }

  /**
   * The field to use as default where no field prefix is given in the query
   * string.
   * API name: {@code df}
   */
  @Nullable
  public final String df() {
    return this.df;
  }

  /**
   * Array of wildcard (*) patterns. The request returns doc values for field
   * names matching these patterns in the hits.fields property of the response.
   * API name: {@code docvalue_fields}
   */
  public final List<FieldAndFormat> docvalueFields() {
    return this.docvalueFields;
  }

  /**
   * Whether to expand wildcard expression to concrete indices that are open,
   * closed or both.
   * API name: {@code expand_wildcards}
   */
  public final List<ExpandWildcard> expandWildcards() {
    return this.expandWildcards;
  }

  /**
   * If true, returns detailed information about score computation as part of a
   * hit.
   * API name: {@code explain}
   */
  @Nullable
  public final Boolean explain() {
    return this.explain;
  }

  /**
   * Array of wildcard (*) patterns. The request returns values for field names
   * matching these patterns in the hits.fields property of the response.
   * API name: {@code fields}
   */
  public final List<FieldAndFormat> fields() {
    return this.fields;
  }

  /**
   * Starting document offset. By default, you cannot page through more than
   * 10,000 hits using the from and size parameters. To page through more hits,
   * use the search_after parameter.
   * API name: {@code from}
   */
  @Nullable
  public final Integer from() {
    return this.from;
  }

  /**
   * API name: {@code highlight}.
   */
  @Nullable
  public final Highlight highlight() {
    return this.highlight;
  }

  /**
   * Whether specified concrete, expanded or aliased indices should be ignored
   * when throttled.
   * API name: {@code ignore_throttled}
   */
  @Nullable
  public final Boolean ignoreThrottled() {
    return this.ignoreThrottled;
  }

  /**
   * Whether specified concrete indices should be ignored when unavailable
   * (missing or closed).
   * API name: {@code ignore_unavailable}
   */
  @Nullable
  public final Boolean ignoreUnavailable() {
    return this.ignoreUnavailable;
  }

  /**
   * A comma-separated list of index names to search; use <code>_all</code> or
   * empty string to perform the operation on all indices.
   * API name: {@code index}
   */
  public final List<String> index() {
    return this.index;
  }

  /**
   * Boosts the _score of documents from specified indices.
   * API name: {@code indices_boost}
   */
  public final List<Map<String, Double>> indicesBoost() {
    return this.indicesBoost;
  }

  /**
   * Specify whether format-based query failures (such as providing text to a
   * numeric field) should be ignored.
   * API name: {@code lenient}
   */
  @Nullable
  public final Boolean lenient() {
    return this.lenient;
  }

  /**
   * The number of concurrent shard requests per node this search executes
   * concurrently. This value should be used to limit the impact of the search on
   * the cluster in order to limit the number of concurrent shard requests.
   * API name: {@code max_concurrent_shard_requests}
   */
  @Nullable
  public final Long maxConcurrentShardRequests() {
    return this.maxConcurrentShardRequests;
  }

  /**
   * The minimum compatible version that all shards involved in search should have
   * for this request to be successful.
   * API name: {@code min_compatible_shard_node}
   */
  @Nullable
  public final String minCompatibleShardNode() {
    return this.minCompatibleShardNode;
  }

  /**
   * Minimum _score for matching documents. Documents with a lower _score are not
   * included in the search results.
   * API name: {@code min_score}
   */
  @Nullable
  public final Double minScore() {
    return this.minScore;
  }

  /**
   * API name: {@code pit}.
   */
  @Nullable
  public final Pit pit() {
    return this.pit;
  }

  /**
   * API name: {@code post_filter}.
   */
  @Nullable
  public final Query postFilter() {
    return this.postFilter;
  }

  /**
   * A threshold that enforces a pre-filter roundtrip to prefilter search shards
   * based on query rewriting if the number of shards the search request expands
   * to exceeds the threshold. This filter roundtrip can limit the number of
   * shards significantly if for instance a shard can not match any documents
   * based on its rewrite method ie. if date filters are mandatory to match but
   * the shard bounds and the query are disjoint.
   * API name: {@code pre_filter_shard_size}
   */
  @Nullable
  public final Long preFilterShardSize() {
    return this.preFilterShardSize;
  }

  /**
   * Specify the node or shard the operation should be performed on (default:
   * random).
   * API name: {@code preference}
   */
  @Nullable
  public final String preference() {
    return this.preference;
  }

  /**
   * API name: {@code profile}.
   */
  @Nullable
  public final Boolean profile() {
    return this.profile;
  }

  /**
   * Query in the Lucene query string syntax.
   * API name: {@code qcheckStyled}
   */
  @Nullable
  public final String qcheckStyled() {
    return this.qcheckStyled
        ;
  }

  /**
   * Defines the search definition using the Query DSL.
   * API name: {@code query}
   */
  @Nullable
  public final Query query() {
    return this.query;
  }

  /**
   * Specify if request cache should be used for this request or not, defaults to
   * index level setting.
   * API name: {@code request_cache}
   */
  @Nullable
  public final Boolean requestCache() {
    return this.requestCache;
  }

  /**
   * API name: {@code rescore}.
   */
  public final List<Rescore> rescore() {
    return this.rescore;
  }

  /**
   * A comma-separated list of specific routing values.
   * API name: {@code routing}
   */
  @Nullable
  public final String routing() {
    return this.routing;
  }

  /**
   * A comma-separated.
   * API name: {@code routing}
   */
  @Nullable
  public final String searchPipeline() {
    return this.searchPipeline;
  }

  /**
   * Defines one or more runtime fields in the search request. These fields take
   * precedence over mapped fields with the same name.
   * API name: {@code runtime_mappings}
   */
  public final Map<String, RuntimeField> runtimeMappings() {
    return this.runtimeMappings;
  }

  /**
   * Retrieve a script evaluation (based on different fields) for each hit.
   * API name: {@code script_fields}
   */
  public final Map<String, ScriptField> scriptFields() {
    return this.scriptFields;
  }

  /**
   * Specify how long a consistent view of the index should be maintained for
   * scrolled search.
   * API name: {@code scroll}
   */
  @Nullable
  public final Time scroll() {
    return this.scroll;
  }

  /**
   * API name: {@code search_after}.
   */
  public final List<FieldValue> searchAfter() {
    return this.searchAfter;
  }

  /**
   * Search operation type.
   * API name: {@code search_type}
   */
  @Nullable
  public final SearchType searchType() {
    return this.searchType;
  }

  /**
   * If true, returns sequence number and primary term of the last modification of
   * each hit. See Optimistic concurrency control.
   * API name: {@code seq_no_primary_term}
   */
  @Nullable
  public final Boolean seqNoPrimaryTerm() {
    return this.seqNoPrimaryTerm;
  }

  /**
   * The number of hits to return. By default, you cannot page through more than
   * 10,000 hits using the from and size parameters. To page through more hits,
   * use the search_after parameter.
   * API name: {@code size}
   */
  @Nullable
  public final Integer size() {
    return this.size;
  }

  /**
   * API name: {@code slice}.
   */
  @Nullable
  public final SlicedScroll slice() {
    return this.slice;
  }

  /**
   * API name: {@code sort}.
   */
  public final List<SortOptions> sort() {
    return this.sort;
  }

  /**
   * Stats groups to associate with the search. Each group maintains a statistics
   * aggregation for its associated searches. You can retrieve these stats using
   * the indices stats API.
   * API name: {@code stats}
   */
  public final List<String> stats() {
    return this.stats;
  }

  /**
   * List of stored fields to return as part of a hit. If no fields are specified,
   * no stored fields are included in the response. If this field is specified,
   * the _source parameter defaults to false. You can pass _source: true to return
   * both source fields and stored fields in the search response.
   * API name: {@code stored_fields}
   */
  public final List<String> storedFields() {
    return this.storedFields;
  }

  /**
   * API name: {@code suggest}.
   */
  @Nullable
  public final Suggester suggest() {
    return this.suggest;
  }

  /**
   * Maximum number of documents to collect for each shard. If a query reaches
   * this limit, OpenSearch terminates the query early. OpenSearch collects
   * documents before sorting. Defaults to 0, which does not terminate query
   * execution early.
   * API name: {@code terminate_after}
   */
  @Nullable
  public final Long terminateAfter() {
    return this.terminateAfter;
  }

  /**
   * Specifies the period of time to wait for a response from each shard. If no
   * response is received before the timeout expires, the request fails and
   * returns an error. Defaults to no timeout.
   * API name: {@code timeout}
   */
  @Nullable
  public final String timeout() {
    return this.timeout;
  }

  /**
   * If true, calculate and return document scores, even if the scores are not
   * used for sorting.
   * API name: {@code track_scores}
   */
  @Nullable
  public final Boolean trackScores() {
    return this.trackScores;
  }

  /**
   * Number of hits matching the query to count accurately. If true, the exact
   * number of hits is returned at the cost of some performance. If false, the
   * response does not include the total number of hits matching the query.
   * Defaults to 10,000 hits.
   * API name: {@code track_total_hits}
   */
  @Nullable
  public final TrackHits trackTotalHits() {
    return this.trackTotalHits;
  }

  /**
   * If true, returns document version as part of a hit.
   * API name: {@code version}
   */
  @Nullable
  public final Boolean version() {
    return this.version;
  }

  // ---------------------------------------------------------------------------------------------

  /**
   * API name: {@code ext}.
   */
  public final Map<String, JsonData> ext() {
    return this.ext;
  }

  // ---------------------------------------------------------------------------------------------

  /**
   * Serialize this object to JSON.
   */
  public void serialize(JsonGenerator generator, JsonpMapper mapper) {
    generator.writeStartObject();
    serializeInternal(generator, mapper);
    generator.writeEnd();
  }

  protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

    if (this.source != null) {
      generator.writeKey("_source");
      this.source.serialize(generator, mapper);

    }
    if (ApiTypeHelper.isDefined(this.aggregations)) {
      generator.writeKey("aggregations");
      generator.writeStartObject();
      for (Map.Entry<String, Aggregation> item0 : this.aggregations.entrySet()) {
        generator.writeKey(item0.getKey());
        item0.getValue().serialize(generator, mapper);

      }
      generator.writeEnd();

    }
    if (this.collapse != null) {
      generator.writeKey("collapse");
      this.collapse.serialize(generator, mapper);

    }
    if (ApiTypeHelper.isDefined(this.docvalueFields)) {
      generator.writeKey("docvalue_fields");
      generator.writeStartArray();
      for (FieldAndFormat item0 : this.docvalueFields) {
        item0.serialize(generator, mapper);

      }
      generator.writeEnd();

    }
    if (this.explain != null) {
      generator.writeKey("explain");
      generator.write(this.explain);

    }
    if (ApiTypeHelper.isDefined(this.fields)) {
      generator.writeKey("fields");
      generator.writeStartArray();
      for (FieldAndFormat item0 : this.fields) {
        item0.serialize(generator, mapper);

      }
      generator.writeEnd();

    }
    if (this.from != null) {
      generator.writeKey("from");
      generator.write(this.from);

    }
    if (this.highlight != null) {
      generator.writeKey("highlight");
      this.highlight.serialize(generator, mapper);

    }
    if (ApiTypeHelper.isDefined(this.indicesBoost)) {
      generator.writeKey("indices_boost");
      generator.writeStartArray();
      for (Map<String, Double> item0 : this.indicesBoost) {
        generator.writeStartObject();
        if (item0 != null) {
          for (Map.Entry<String, Double> item1 : item0.entrySet()) {
            generator.writeKey(item1.getKey());
            generator.write(item1.getValue());

          }
        }
        generator.writeEnd();

      }
      generator.writeEnd();

    }
    if (this.minScore != null) {
      generator.writeKey("min_score");
      generator.write(this.minScore);

    }

    if (this.pit != null) {
      generator.writeKey("pit");
      this.pit.serialize(generator, mapper);
    }

    if (this.postFilter != null) {
      generator.writeKey("post_filter");
      this.postFilter.serialize(generator, mapper);

    }
    if (this.profile != null) {
      generator.writeKey("profile");
      generator.write(this.profile);

    }
    if (this.query != null) {
      generator.writeKey("query");
      this.query.serialize(generator, mapper);

    }
    if (ApiTypeHelper.isDefined(this.rescore)) {
      generator.writeKey("rescore");
      generator.writeStartArray();
      for (Rescore item0 : this.rescore) {
        item0.serialize(generator, mapper);

      }
      generator.writeEnd();

    }
    if (ApiTypeHelper.isDefined(this.runtimeMappings)) {
      generator.writeKey("runtime_mappings");
      generator.writeStartObject();
      for (Map.Entry<String, RuntimeField> item0 : this.runtimeMappings.entrySet()) {
        generator.writeKey(item0.getKey());
        item0.getValue().serialize(generator, mapper);

      }
      generator.writeEnd();

    }
    if (ApiTypeHelper.isDefined(this.scriptFields)) {
      generator.writeKey("script_fields");
      generator.writeStartObject();
      for (Map.Entry<String, ScriptField> item0 : this.scriptFields.entrySet()) {
        generator.writeKey(item0.getKey());
        item0.getValue().serialize(generator, mapper);

      }
      generator.writeEnd();

    }
    if (ApiTypeHelper.isDefined(this.searchAfter)) {
      generator.writeKey("search_after");
      generator.writeStartArray();
      for (FieldValue item0 : this.searchAfter) {
        item0.serialize(generator, mapper);

      }
      generator.writeEnd();

    }
    if (this.seqNoPrimaryTerm != null) {
      generator.writeKey("seq_no_primary_term");
      generator.write(this.seqNoPrimaryTerm);

    }
    if (this.size != null) {
      generator.writeKey("size");
      generator.write(this.size);

    }
    if (this.slice != null) {
      generator.writeKey("slice");
      this.slice.serialize(generator, mapper);

    }
    if (ApiTypeHelper.isDefined(this.sort)) {
      generator.writeKey("sort");
      generator.writeStartArray();
      for (SortOptions item0 : this.sort) {
        item0.serialize(generator, mapper);

      }
      generator.writeEnd();

    }
    if (ApiTypeHelper.isDefined(this.stats)) {
      generator.writeKey("stats");
      generator.writeStartArray();
      for (String item0 : this.stats) {
        generator.write(item0);

      }
      generator.writeEnd();

    }
    if (ApiTypeHelper.isDefined(this.storedFields)) {
      generator.writeKey("stored_fields");
      generator.writeStartArray();
      for (String item0 : this.storedFields) {
        generator.write(item0);

      }
      generator.writeEnd();

    }
    if (this.suggest != null) {
      generator.writeKey("suggest");
      this.suggest.serialize(generator, mapper);

    }
    if (this.terminateAfter != null) {
      generator.writeKey("terminate_after");
      generator.write(this.terminateAfter);

    }
    if (this.timeout != null) {
      generator.writeKey("timeout");
      generator.write(this.timeout);

    }
    if (this.trackScores != null) {
      generator.writeKey("track_scores");
      generator.write(this.trackScores);

    }
    if (this.trackTotalHits != null) {
      generator.writeKey("track_total_hits");
      this.trackTotalHits.serialize(generator, mapper);

    }
    if (this.version != null) {
      generator.writeKey("version");
      generator.write(this.version);

    }

    if (ApiTypeHelper.isDefined(this.ext)) {
      generator.writeKey("ext");
      generator.writeStartObject();
      for (Map.Entry<String, JsonData> item0 : this.ext.entrySet()) {
        generator.writeKey(item0.getKey());
        item0.getValue().serialize(generator, mapper);

      }
      generator.writeEnd();
    }

  }

  /**
   * Alternate toBuilder().
   */
  public HybridSearchRequest.Builder toBuilder() {
    return new HybridSearchRequest.Builder().source(source)
        .aggregations(aggregations)
        .allowNoIndices(allowNoIndices)
        .allowPartialSearchResults(allowPartialSearchResults)
        .analyzeWildcard(analyzeWildcard)
        .analyzer(analyzer)
        .batchedReduceSize(batchedReduceSize)
        .ccsMinimizeRoundtrips(ccsMinimizeRoundtrips)
        .collapse(collapse)
        .defaultOperator(defaultOperator)
        .df(df)
        .docvalueFields(docvalueFields)
        .expandWildcards(expandWildcards)
        .explain(explain)
        .fields(fields)
        .from(from)
        .highlight(highlight)
        .ignoreThrottled(ignoreThrottled)
        .ignoreUnavailable(ignoreUnavailable)
        .index(index)
        .indicesBoost(indicesBoost)
        .lenient(lenient)
        .maxConcurrentShardRequests(maxConcurrentShardRequests)
        .minCompatibleShardNode(minCompatibleShardNode)
        .minScore(minScore)
        .pit(pit)
        .postFilter(postFilter)
        .preFilterShardSize(preFilterShardSize)
        .preference(preference)
        .profile(profile)
        .qcheckStyled(qcheckStyled
        )
        .query(query)
        .requestCache(requestCache)
        .rescore(rescore)
        .routing(routing)
        .runtimeMappings(runtimeMappings)
        .scriptFields(scriptFields)
        .scroll(scroll)
        .searchAfter(searchAfter)
        .searchType(searchType)
        .seqNoPrimaryTerm(seqNoPrimaryTerm)
        .size(size)
        .slice(slice)
        .sort(sort)
        .stats(stats)
        .storedFields(storedFields)
        .suggest(suggest)
        .terminateAfter(terminateAfter)
        .timeout(timeout)
        .trackScores(trackScores)
        .trackTotalHits(trackTotalHits)
        .version(version)
        .ext(ext)
        .routing(searchPipeline);
  }

  /**
   * Builder for {@link HybridSearchRequest}.
   */

  public static class Builder extends ObjectBuilderBase
      implements ObjectBuilder<HybridSearchRequest> {
    @Nullable
    private SourceConfig source;

    @Nullable
    private Map<String, Aggregation> aggregations;

    @Nullable
    private Boolean allowNoIndices;

    @Nullable
    private Boolean allowPartialSearchResults;

    @Nullable
    private Boolean analyzeWildcard;

    @Nullable
    private String analyzer;

    @Nullable
    private Long batchedReduceSize;

    @Nullable
    private Boolean ccsMinimizeRoundtrips;

    @Nullable
    private FieldCollapse collapse;

    @Nullable
    private Operator defaultOperator;

    @Nullable
    private String df;

    @Nullable
    private List<FieldAndFormat> docvalueFields;

    @Nullable
    private List<ExpandWildcard> expandWildcards;

    @Nullable
    private Boolean explain;

    @Nullable
    private List<FieldAndFormat> fields;

    @Nullable
    private Integer from;

    @Nullable
    private Highlight highlight;

    @Nullable
    private Boolean ignoreThrottled;

    @Nullable
    private Boolean ignoreUnavailable;

    @Nullable
    private List<String> index;

    @Nullable
    private List<Map<String, Double>> indicesBoost;

    @Nullable
    private Boolean lenient;

    @Nullable
    private Long maxConcurrentShardRequests;

    @Nullable
    private String minCompatibleShardNode;

    @Nullable
    private Double minScore;

    @Nullable
    private Pit pit;

    @Nullable
    private Query postFilter;

    @Nullable
    private Long preFilterShardSize;

    @Nullable
    private String preference;

    @Nullable
    private Boolean profile;

    @Nullable
    private String qcheckStyled;

    @Nullable
    private Query query;

    @Nullable
    private Boolean requestCache;

    @Nullable
    private List<Rescore> rescore;

    @Nullable
    private String routing;

    @Nullable
    private Map<String, RuntimeField> runtimeMappings;

    @Nullable
    private Map<String, ScriptField> scriptFields;

    @Nullable
    private Time scroll;

    @Nullable
    private List<FieldValue> searchAfter;

    @Nullable
    private SearchType searchType;

    @Nullable
    private Boolean seqNoPrimaryTerm;

    @Nullable
    private Integer size;

    @Nullable
    private SlicedScroll slice;

    @Nullable
    private List<SortOptions> sort;

    @Nullable
    private List<String> stats;

    @Nullable
    private List<String> storedFields;

    @Nullable
    private Suggester suggest;

    @Nullable
    private Long terminateAfter;

    @Nullable
    private String timeout;

    @Nullable
    private Boolean trackScores;

    @Nullable
    private TrackHits trackTotalHits;

    @Nullable
    private Boolean version;

    @Nullable
    private Map<String, JsonData> ext;

    @Nullable
    private String searchPipeline;

    /**
     * Indicates which source fields are returned for matching documents. These
     * fields are returned in the hits._source property of the search response.
     * API name: {@code _source}
     */
    public final HybridSearchRequest.Builder source(@Nullable SourceConfig value) {
      this.source = value;
      return this;
    }

    /**
     * Indicates which source fields are returned for matching documents. These
     * fields are returned in the hits._source property of the search response.
     * API name: {@code _source}
     */
    public final HybridSearchRequest.Builder source(
        Function<SourceConfig.Builder, ObjectBuilder<SourceConfig>> fn) {
      return this.source(fn.apply(new SourceConfig.Builder()).build());
    }

    /**
     * API name: {@code aggregations}.
     * Adds all entries of <code>map</code> to <code>aggregations</code>.
     */
    public final HybridSearchRequest.Builder aggregations(Map<String, Aggregation> map) {
      this.aggregations = _mapPutAll(this.aggregations, map);
      return this;
    }

    /**
     * API name: {@code aggregations}.
     * Adds an entry to <code>aggregations</code>.
     */
    public final HybridSearchRequest.Builder aggregations(String key, Aggregation value) {
      this.aggregations = _mapPut(this.aggregations, key, value);
      return this;
    }

    /**
     * API name: {@code aggregations}.
     * Adds an entry to <code>aggregations</code> using a builder lambda.
     */
    public final HybridSearchRequest.Builder aggregations(String key,
                                                          Function<Aggregation.Builder,
                                                              ObjectBuilder<Aggregation>> fn) {
      return aggregations(key, fn.apply(new Aggregation.Builder()).build());
    }

    /**
     * Whether to ignore if a wildcard indices expression resolves into no concrete
     * indices. (This includes <code>_all</code> string or when no indices have been
     * specified).
     * API name: {@code allow_no_indices}
     */
    public final HybridSearchRequest.Builder allowNoIndices(@Nullable Boolean value) {
      this.allowNoIndices = value;
      return this;
    }

    /**
     * Indicate if an error should be returned if there is a partial search failure
     * or timeout.
     * API name: {@code allow_partial_search_results}
     */
    public final HybridSearchRequest.Builder allowPartialSearchResults(@Nullable Boolean value) {
      this.allowPartialSearchResults = value;
      return this;
    }

    /**
     * Specify whether wildcard and prefix queries should be analyzed (default:
     * false).
     * API name: {@code analyze_wildcard}
     */
    public final HybridSearchRequest.Builder analyzeWildcard(@Nullable Boolean value) {
      this.analyzeWildcard = value;
      return this;
    }

    /**
     * The analyzer to use for the query string.
     * API name: {@code analyzer}
     */
    public final HybridSearchRequest.Builder analyzer(@Nullable String value) {
      this.analyzer = value;
      return this;
    }

    /**
     * The number of shard results that should be reduced at once on the
     * coordinating node. This value should be used as a protection mechanism to
     * reduce the memory overhead per search request if the potential number of
     * shards in the request can be large.
     * API name: {@code batched_reduce_size}
     */
    public final HybridSearchRequest.Builder batchedReduceSize(@Nullable Long value) {
      this.batchedReduceSize = value;
      return this;
    }

    /**
     * Indicates whether network round-trips should be minimized as part of
     * cross-cluster search requests execution.
     * API name: {@code ccs_minimize_roundtrips}
     */
    public final HybridSearchRequest.Builder ccsMinimizeRoundtrips(@Nullable Boolean value) {
      this.ccsMinimizeRoundtrips = value;
      return this;
    }

    /**
     * API name: {@code collapse}.
     */
    public final HybridSearchRequest.Builder collapse(@Nullable FieldCollapse value) {
      this.collapse = value;
      return this;
    }

    /**
     * API name: {@code collapse}.
     */
    public final HybridSearchRequest.Builder collapse(
        Function<FieldCollapse.Builder, ObjectBuilder<FieldCollapse>> fn) {
      return this.collapse(fn.apply(new FieldCollapse.Builder()).build());
    }

    /**
     * The default operator for query string query (AND or OR).
     * API name: {@code default_operator}
     */
    public final HybridSearchRequest.Builder defaultOperator(@Nullable Operator value) {
      this.defaultOperator = value;
      return this;
    }

    /**
     * The field to use as default where no field prefix is given in the query
     * string.
     * API name: {@code df}
     */
    public final HybridSearchRequest.Builder df(@Nullable String value) {
      this.df = value;
      return this;
    }

    /**
     * Array of wildcard (*) patterns. The request returns doc values for field
     * names matching these patterns in the hits.fields property of the response.
     * API name: {@code docvalue_fields}
     * Adds all elements of <code>list</code> to <code>docvalueFields</code>.
     */
    public final HybridSearchRequest.Builder docvalueFields(List<FieldAndFormat> list) {
      this.docvalueFields = _listAddAll(this.docvalueFields, list);
      return this;
    }

    /**
     * Array of wildcard (*) patterns. The request returns doc values for field
     * names matching these patterns in the hits.fields property of the response.
     * API name: {@code docvalue_fields}
     * Adds one or more values to <code>docvalueFields</code>.
     */
    public final HybridSearchRequest.Builder docvalueFields(FieldAndFormat value,
                                                            FieldAndFormat... values) {
      this.docvalueFields = _listAdd(this.docvalueFields, value, values);
      return this;
    }

    /**
     * Array of wildcard (*) patterns. The request returns doc values for field
     * names matching these patterns in the hits.fields property of the response.
     * API name: {@code docvalue_fields}
     * Adds a value to <code>docvalueFields</code> using a builder lambda.
     */
    public final HybridSearchRequest.Builder docvalueFields(
        Function<FieldAndFormat.Builder, ObjectBuilder<FieldAndFormat>> fn) {
      return docvalueFields(fn.apply(new FieldAndFormat.Builder()).build());
    }

    /**
     * Whether to expand wildcard expression to concrete indices that are open,
     * closed or both.
     * API name: {@code expand_wildcards}
     * Adds all elements of <code>list</code> to <code>expandWildcards</code>.
     */
    public final HybridSearchRequest.Builder expandWildcards(List<ExpandWildcard> list) {
      this.expandWildcards = _listAddAll(this.expandWildcards, list);
      return this;
    }

    /**
     * Whether to expand wildcard expression to concrete indices that are open,
     * closed or both.
     * API name: {@code expand_wildcards}
     * Adds one or more values to <code>expandWildcards</code>.
     */
    public final HybridSearchRequest.Builder expandWildcards(ExpandWildcard value,
                                                             ExpandWildcard... values) {
      this.expandWildcards = _listAdd(this.expandWildcards, value, values);
      return this;
    }

    /**
     * If true, returns detailed information about score computation as part of a
     * hit.
     * API name: {@code explain}
     */
    public final HybridSearchRequest.Builder explain(@Nullable Boolean value) {
      this.explain = value;
      return this;
    }

    /**
     * Array of wildcard (*) patterns. The request returns values for field names
     * matching these patterns in the hits.fields property of the response.
     * API name: {@code fields}
     * Adds all elements of <code>list</code> to <code>fields</code>.
     */
    public final HybridSearchRequest.Builder fields(List<FieldAndFormat> list) {
      this.fields = _listAddAll(this.fields, list);
      return this;
    }

    /**
     * Array of wildcard (*) patterns. The request returns values for field names
     * matching these patterns in the hits.fields property of the response.
     * API name: {@code fields}
     * Adds one or more values to <code>fields</code>.
     */
    public final HybridSearchRequest.Builder fields(FieldAndFormat value,
                                                    FieldAndFormat... values) {
      this.fields = _listAdd(this.fields, value, values);
      return this;
    }

    /**
     * Array of wildcard (*) patterns. The request returns values for field names
     * matching these patterns in the hits.fields property of the response.
     * API name: {@code fields}
     * Adds a value to <code>fields</code> using a builder lambda.
     */
    public final HybridSearchRequest.Builder fields(
        Function<FieldAndFormat.Builder, ObjectBuilder<FieldAndFormat>> fn) {
      return fields(fn.apply(new FieldAndFormat.Builder()).build());
    }

    /**
     * Starting document offset. By default, you cannot page through more than
     * 10,000 hits using the from and size parameters. To page through more hits,
     * use the search_after parameter.
     * API name: {@code from}
     */
    public final HybridSearchRequest.Builder from(@Nullable Integer value) {
      this.from = value;
      return this;
    }

    /**
     * API name: {@code highlight}.
     */
    public final HybridSearchRequest.Builder highlight(@Nullable Highlight value) {
      this.highlight = value;
      return this;
    }

    /**
     * API name: {@code highlight}.
     */
    public final HybridSearchRequest.Builder highlight(
        Function<Highlight.Builder, ObjectBuilder<Highlight>> fn) {
      return this.highlight(fn.apply(new Highlight.Builder()).build());
    }

    /**
     * Whether specified concrete, expanded or aliased indices should be ignored
     * when throttled.
     * API name: {@code ignore_throttled}
     */
    public final HybridSearchRequest.Builder ignoreThrottled(@Nullable Boolean value) {
      this.ignoreThrottled = value;
      return this;
    }

    /**
     * Whether specified concrete indices should be ignored when unavailable
     * (missing or closed).
     * API name: {@code ignore_unavailable}
     */
    public final HybridSearchRequest.Builder ignoreUnavailable(@Nullable Boolean value) {
      this.ignoreUnavailable = value;
      return this;
    }

    /**
     * A comma-separated list of index names to search; use <code>_all</code> or
     * empty string to perform the operation on all indices.
     * API name: {@code index}
     * Adds all elements of <code>list</code> to <code>index</code>.
     */
    public final HybridSearchRequest.Builder index(List<String> list) {
      this.index = _listAddAll(this.index, list);
      return this;
    }

    /**
     * A comma-separated list of index names to search; use <code>_all</code> or
     * empty string to perform the operation on all indices.
     * API name: {@code index}
     * Adds one or more values to <code>index</code>.
     */
    public final HybridSearchRequest.Builder index(String value, String... values) {
      this.index = _listAdd(this.index, value, values);
      return this;
    }

    /**
     * Boosts the _score of documents from specified indices.
     * API name: {@code indices_boost}
     * Adds all elements of <code>list</code> to <code>indicesBoost</code>.
     */
    public final HybridSearchRequest.Builder indicesBoost(List<Map<String, Double>> list) {
      this.indicesBoost = _listAddAll(this.indicesBoost, list);
      return this;
    }

    /**
     * Boosts the _score of documents from specified indices.
     * API name: {@code indices_boost}
     * Adds one or more values to <code>indicesBoost</code>.
     */
    public final HybridSearchRequest.Builder indicesBoost(Map<String, Double> value,
                                                          Map<String, Double>... values) {
      this.indicesBoost = _listAdd(this.indicesBoost, value, values);
      return this;
    }

    /**
     * Specify whether format-based query failures (such as providing text to a
     * numeric field) should be ignored.
     * API name: {@code lenient}
     */
    public final HybridSearchRequest.Builder lenient(@Nullable Boolean value) {
      this.lenient = value;
      return this;
    }

    /**
     * The number of concurrent shard requests per node this search executes
     * concurrently. This value should be used to limit the impact of the search on
     * the cluster in order to limit the number of concurrent shard requests.
     * API name: {@code max_concurrent_shard_requests}
     */
    public final HybridSearchRequest.Builder maxConcurrentShardRequests(@Nullable Long value) {
      this.maxConcurrentShardRequests = value;
      return this;
    }

    /**
     * The minimum compatible version that all shards involved in search should have
     * for this request to be successful.
     * API name: {@code min_compatible_shard_node}
     */
    public final HybridSearchRequest.Builder minCompatibleShardNode(@Nullable String value) {
      this.minCompatibleShardNode = value;
      return this;
    }

    /**
     * Minimum _score for matching documents. Documents with a lower _score are not
     * included in the search results.
     * API name: {@code min_score}
     */
    public final HybridSearchRequest.Builder minScore(@Nullable Double value) {
      this.minScore = value;
      return this;
    }

    /**
     * API name: {@code pit}.
     */
    public final HybridSearchRequest.Builder pit(@Nullable Pit pit) {
      this.pit = pit;
      return this;
    }

    /**
     * API name: {@code post_filter}.
     */
    public final HybridSearchRequest.Builder postFilter(@Nullable Query value) {
      this.postFilter = value;
      return this;
    }

    /**
     * API name: {@code post_filter}.
     */
    public final HybridSearchRequest.Builder postFilter(
        Function<Query.Builder, ObjectBuilder<Query>> fn) {
      return this.postFilter(fn.apply(new Query.Builder()).build());
    }

    /**
     * A threshold that enforces a pre-filter roundtrip to prefilter search shards
     * based on query rewriting if the number of shards the search request expands
     * to exceeds the threshold. This filter roundtrip can limit the number of
     * shards significantly if for instance a shard can not match any documents
     * based on its rewrite method ie. if date filters are mandatory to match but
     * the shard bounds and the query are disjoint.
     * API name: {@code pre_filter_shard_size}
     */
    public final HybridSearchRequest.Builder preFilterShardSize(@Nullable Long value) {
      this.preFilterShardSize = value;
      return this;
    }

    /**
     * Specify the node or shard the operation should be performed on (default:
     * random).
     * API name: {@code preference}
     */
    public final HybridSearchRequest.Builder preference(@Nullable String value) {
      this.preference = value;
      return this;
    }

    /**
     * API name: {@code profile}.
     */
    public final HybridSearchRequest.Builder profile(@Nullable Boolean value) {
      this.profile = value;
      return this;
    }

    /**
     * Query in the Lucene query string syntax.
     * API name: {@code qcheckStyled}
     */
    public final HybridSearchRequest.Builder qcheckStyled(@Nullable String value) {
      this.qcheckStyled
          = value;
      return this;
    }

    /**
     * Defines the search definition using the Query DSL.
     * API name: {@code query}
     */
    public final HybridSearchRequest.Builder query(@Nullable Query value) {
      this.query = value;
      return this;
    }

    /**
     * Defines the search definition using the Query DSL.
     * API name: {@code query}
     */
    public final HybridSearchRequest.Builder query(
        Function<Query.Builder, ObjectBuilder<Query>> fn) {
      return this.query(fn.apply(new Query.Builder()).build());
    }

    /**
     * Specify if request cache should be used for this request or not, defaults to
     * index level setting.
     * API name: {@code request_cache}
     */
    public final HybridSearchRequest.Builder requestCache(@Nullable Boolean value) {
      this.requestCache = value;
      return this;
    }

    /**
     * API name: {@code rescore}.
     * Adds all elements of <code>list</code> to <code>rescore</code>.
     */
    public final HybridSearchRequest.Builder rescore(List<Rescore> list) {
      this.rescore = _listAddAll(this.rescore, list);
      return this;
    }

    /**
     * API name: {@code rescore}.
     * Adds one or more values to <code>rescore</code>.
     */
    public final HybridSearchRequest.Builder rescore(Rescore value, Rescore... values) {
      this.rescore = _listAdd(this.rescore, value, values);
      return this;
    }

    /**
     * API name: {@code rescore}.
     * Adds a value to <code>rescore</code> using a builder lambda.
     */
    public final HybridSearchRequest.Builder rescore(
        Function<Rescore.Builder, ObjectBuilder<Rescore>> fn) {
      return rescore(fn.apply(new Rescore.Builder()).build());
    }

    /**
     * A comma-separated list of specific routing values.
     * API name: {@code routing}
     */
    public final HybridSearchRequest.Builder routing(@Nullable String value) {
      this.routing = value;
      return this;
    }

    /**
     * A comma-separated.
     * API name: {@code routing}
     */
    public final HybridSearchRequest.Builder searchPipeline(@Nullable String value) {
      this.searchPipeline = value;
      return this;
    }

    /**
     * Defines one or more runtime fields in the search request. These fields take
     * precedence over mapped fields with the same name.
     * API name: {@code runtime_mappings}
     * Adds all entries of <code>map</code> to <code>runtimeMappings</code>.
     */
    public final HybridSearchRequest.Builder runtimeMappings(Map<String, RuntimeField> map) {
      this.runtimeMappings = _mapPutAll(this.runtimeMappings, map);
      return this;
    }

    /**
     * Defines one or more runtime fields in the search request. These fields take
     * precedence over mapped fields with the same name.
     * API name: {@code runtime_mappings}
     * Adds an entry to <code>runtimeMappings</code>.
     */
    public final HybridSearchRequest.Builder runtimeMappings(String key, RuntimeField value) {
      this.runtimeMappings = _mapPut(this.runtimeMappings, key, value);
      return this;
    }

    /**
     * Defines one or more runtime fields in the search request. These fields take
     * precedence over mapped fields with the same name.
     * API name: {@code runtime_mappings}
     * Adds an entry to <code>runtimeMappings</code> using a builder lambda.
     */
    public final HybridSearchRequest.Builder runtimeMappings(String key,
                                                             Function<RuntimeField.Builder,
                                                                 ObjectBuilder<RuntimeField>> fn) {
      return runtimeMappings(key, fn.apply(new RuntimeField.Builder()).build());
    }

    /**
     * Retrieve a script evaluation (based on different fields) for each hit.
     * API name: {@code script_fields}
     * Adds all entries of <code>map</code> to <code>scriptFields</code>.
     */
    public final HybridSearchRequest.Builder scriptFields(Map<String, ScriptField> map) {
      this.scriptFields = _mapPutAll(this.scriptFields, map);
      return this;
    }

    /**
     * Retrieve a script evaluation (based on different fields) for each hit.
     * API name: {@code script_fields}
     * Adds an entry to <code>scriptFields</code>.
     */
    public final HybridSearchRequest.Builder scriptFields(String key, ScriptField value) {
      this.scriptFields = _mapPut(this.scriptFields, key, value);
      return this;
    }

    /**
     * Retrieve a script evaluation (based on different fields) for each hit.
     * API name: {@code script_fields}
     * Adds an entry to <code>scriptFields</code> using a builder lambda.
     */
    public final HybridSearchRequest.Builder scriptFields(String key,
                                                          Function<ScriptField.Builder,
                                                              ObjectBuilder<ScriptField>> fn) {
      return scriptFields(key, fn.apply(new ScriptField.Builder()).build());
    }

    /**
     * Specify how long a consistent view of the index should be maintained for
     * scrolled search.
     * API name: {@code scroll}
     */
    public final HybridSearchRequest.Builder scroll(@Nullable Time value) {
      this.scroll = value;
      return this;
    }

    /**
     * Specify how long a consistent view of the index should be maintained for
     * scrolled search.
     * API name: {@code scroll}
     */
    public final HybridSearchRequest.Builder scroll(Function<Time.Builder,
        ObjectBuilder<Time>> fn) {
      return this.scroll(fn.apply(new Time.Builder()).build());
    }

    /**
     * API name: {@code search_after}.
     * Adds all elements of <code>list</code> to <code>searchAfter</code>.
     */
    public final HybridSearchRequest.Builder searchAfter(List<FieldValue> list) {
      this.searchAfter = _listAddAll(this.searchAfter, list);
      return this;
    }

    /**
     * API name: {@code search_after}.
     * Adds one or more values to <code>searchAfter</code>.
     */
    public final HybridSearchRequest.Builder searchAfter(FieldValue value, FieldValue... values) {
      this.searchAfter = _listAdd(this.searchAfter, value, values);
      return this;
    }

    /**
     * Search operation type.
     * API name: {@code search_type}
     */
    public final HybridSearchRequest.Builder searchType(@Nullable SearchType value) {
      this.searchType = value;
      return this;
    }

    /**
     * If true, returns sequence number and primary term of the last modification of
     * each hit. See Optimistic concurrency control.
     * API name: {@code seq_no_primary_term}
     */
    public final HybridSearchRequest.Builder seqNoPrimaryTerm(@Nullable Boolean value) {
      this.seqNoPrimaryTerm = value;
      return this;
    }

    /**
     * The number of hits to return. By default, you cannot page through more than
     * 10,000 hits using the from and size parameters. To page through more hits,
     * use the search_after parameter.
     * API name: {@code size}
     */
    public final HybridSearchRequest.Builder size(@Nullable Integer value) {
      this.size = value;
      return this;
    }

    /**
     * API name: {@code slice}.
     */
    public final HybridSearchRequest.Builder slice(@Nullable SlicedScroll value) {
      this.slice = value;
      return this;
    }

    /**
     * API name: {@code slice}.
     */
    public final HybridSearchRequest.Builder slice(
        Function<SlicedScroll.Builder, ObjectBuilder<SlicedScroll>> fn) {
      return this.slice(fn.apply(new SlicedScroll.Builder()).build());
    }

    /**
     * API name: {@code sort}.
     * Adds all elements of <code>list</code> to <code>sort</code>.
     */
    public final HybridSearchRequest.Builder sort(List<SortOptions> list) {
      this.sort = _listAddAll(this.sort, list);
      return this;
    }

    /**
     * API name: {@code sort}.
     * Adds one or more values to <code>sort</code>.
     */
    public final HybridSearchRequest.Builder sort(SortOptions value, SortOptions... values) {
      this.sort = _listAdd(this.sort, value, values);
      return this;
    }

    /**
     * API name: {@code sort}.
     * Adds a value to <code>sort</code> using a builder lambda.
     */
    public final HybridSearchRequest.Builder sort(
        Function<SortOptions.Builder, ObjectBuilder<SortOptions>> fn) {
      return sort(fn.apply(new SortOptions.Builder()).build());
    }

    /**
     * Stats groups to associate with the search. Each group maintains a statistics
     * aggregation for its associated searches. You can retrieve these stats using
     * the indices stats API.
     * API name: {@code stats}
     * Adds all elements of <code>list</code> to <code>stats</code>.
     */
    public final HybridSearchRequest.Builder stats(List<String> list) {
      this.stats = _listAddAll(this.stats, list);
      return this;
    }

    /**
     * Stats groups to associate with the search. Each group maintains a statistics
     * aggregation for its associated searches. You can retrieve these stats using
     * the indices stats API.
     * API name: {@code stats}
     * Adds one or more values to <code>stats</code>.
     */
    public final HybridSearchRequest.Builder stats(String value, String... values) {
      this.stats = _listAdd(this.stats, value, values);
      return this;
    }

    /**
     * List of stored fields to return as part of a hit. If no fields are specified,
     * no stored fields are included in the response. If this field is specified,
     * the _source parameter defaults to false. You can pass _source: true to return
     * both source fields and stored fields in the search response.
     * API name: {@code stored_fields}
     * Adds all elements of <code>list</code> to <code>storedFields</code>.
     */
    public final HybridSearchRequest.Builder storedFields(List<String> list) {
      this.storedFields = _listAddAll(this.storedFields, list);
      return this;
    }

    /**
     * List of stored fields to return as part of a hit. If no fields are specified,
     * no stored fields are included in the response. If this field is specified,
     * the _source parameter defaults to false. You can pass _source: true to return
     * both source fields and stored fields in the search response.
     * API name: {@code stored_fields}
     * Adds one or more values to <code>storedFields</code>.
     */
    public final HybridSearchRequest.Builder storedFields(String value, String... values) {
      this.storedFields = _listAdd(this.storedFields, value, values);
      return this;
    }

    /**
     * API name: {@code suggest}.
     */
    public final HybridSearchRequest.Builder suggest(@Nullable Suggester value) {
      this.suggest = value;
      return this;
    }

    /**
     * API name: {@code suggest}.
     */
    public final HybridSearchRequest.Builder suggest(
        Function<Suggester.Builder, ObjectBuilder<Suggester>> fn) {
      return this.suggest(fn.apply(new Suggester.Builder()).build());
    }

    /**
     * Maximum number of documents to collect for each shard. If a query reaches
     * this limit, OpenSearch terminates the query early. OpenSearch collects
     * documents before sorting. Defaults to 0, which does not terminate query
     * execution early.
     * API name: {@code terminate_after}
     */
    public final HybridSearchRequest.Builder terminateAfter(@Nullable Long value) {
      this.terminateAfter = value;
      return this;
    }

    /**
     * Specifies the period of time to wait for a response from each shard. If no
     * response is received before the timeout expires, the request fails and
     * returns an error. Defaults to no timeout.
     * API name: {@code timeout}
     */
    public final HybridSearchRequest.Builder timeout(@Nullable String value) {
      this.timeout = value;
      return this;
    }

    /**
     * If true, calculate and return document scores, even if the scores are not
     * used for sorting.
     * API name: {@code track_scores}
     */
    public final HybridSearchRequest.Builder trackScores(@Nullable Boolean value) {
      this.trackScores = value;
      return this;
    }

    /**
     * Number of hits matching the query to count accurately. If true, the exact
     * number of hits is returned at the cost of some performance. If false, the
     * response does not include the total number of hits matching the query.
     * Defaults to 10,000 hits.
     * API name: {@code track_total_hits}
     */
    public final HybridSearchRequest.Builder trackTotalHits(@Nullable TrackHits value) {
      this.trackTotalHits = value;
      return this;
    }

    /**
     * Number of hits matching the query to count accurately. If true, the exact
     * number of hits is returned at the cost of some performance. If false, the
     * response does not include the total number of hits matching the query.
     * Defaults to 10,000 hits.
     * API name: {@code track_total_hits}
     */
    public final HybridSearchRequest.Builder trackTotalHits(
        Function<TrackHits.Builder, ObjectBuilder<TrackHits>> fn) {
      return this.trackTotalHits(fn.apply(new TrackHits.Builder()).build());
    }

    /**
     * If true, returns document version as part of a hit.
     * API name: {@code version}
     */
    public final HybridSearchRequest.Builder version(@Nullable Boolean value) {
      this.version = value;
      return this;
    }

    /**
     * API name: {@code ext}.
     * Adds all entries of <code>map</code> to <code>ext</code>.
     */
    public final HybridSearchRequest.Builder ext(Map<String, JsonData> map) {
      this.ext = _mapPutAll(this.ext, map);
      return this;
    }

    /**
     * API name: {@code ext}.
     * Adds an entry to <code>ext</code>.
     */
    public final HybridSearchRequest.Builder ext(String key, JsonData value) {
      this.ext = _mapPut(this.ext, key, value);
      return this;
    }

    /**
     * Builds a {@link HybridSearchRequest}.
     *
     * @throws NullPointerException if some of the required fields are null.
     */
    public HybridSearchRequest build() {
      _checkSingleUse();

      return new HybridSearchRequest(this);
    }
  }
}