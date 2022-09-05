package ba.fet.rwa.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import ba.fet.rwa.model.Quiz;
import ba.fet.rwa.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@Path("/admin")
public class AdminQuizApi {
    @GET
    @Path("/quizzes")
    @Produces({ "application/json" })
    @Operation(
        summary = "Returns all quizzes", description = "Returns an array of all quizzes user has access to",
        security = { @SecurityRequirement(name = "user_auth") },
        tags = { "quiz" })
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "successful operation",
            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Quiz.class)))),
        @ApiResponse(responseCode = "401", description = "Unauthorized quiz access") })
    public List<Quiz> getAllQuizzes(@Context SecurityContext securityContext) throws NotFoundException {
        return new ArrayList<Quiz>();
    }
}