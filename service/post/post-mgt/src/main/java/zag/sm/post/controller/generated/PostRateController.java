/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package zag.sm.post.controller.generated;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zag.sm.post.model.generated.ErrorVTO;
import zag.sm.post.model.generated.PostRateDTO;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
@Validated
@Controller
@Tag(name = "Post Rate", description = "the Post Rate API")
public interface PostRateController {

    /**
     * GET /posts/{postId}/rates/average : Get Post Average Rating
     *
     * @param postId
     *            (required)
     *
     * @return OK (status code 200) or Bad Request (status code 400) or Internal Server Error (status code 500)
     */
    @Operation(operationId = "getPostAverageRating", summary = "Get Post Average Rating", tags = {
            "Post Rate" }, responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Float.class)) }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorVTO.class)) }),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorVTO.class)) }) })
    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}/rates/average", produces = {
            "application/json" })

    ResponseEntity<Float> _getPostAverageRating(
            @Parameter(name = "postId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("postId") Long postId);

    /**
     * PUT /posts/{postId}/rate : Rate Post
     *
     * @param postId
     *            (required)
     * @param postRateDTO
     *            (optional)
     *
     * @return No Content (status code 204) or Bad Request (status code 400) or Internal Server Error (status code 500)
     */
    @Operation(operationId = "ratePost", summary = "Rate Post", tags = { "Post Rate" }, responses = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorVTO.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorVTO.class)) }) })
    @RequestMapping(method = RequestMethod.PUT, value = "/posts/{postId}/rate", produces = {
            "application/json" }, consumes = { "application/json" })

    ResponseEntity<Void> _ratePost(
            @Parameter(name = "postId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("postId") Long postId,
            @Parameter(name = "PostRateDTO", description = "") @Valid @RequestBody(required = false) PostRateDTO postRateDTO);

}
