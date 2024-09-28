package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import java.math.BigDecimal;

@Path("/accounts")
@Produces("application/json")
@Consumes("application/json")
public class AccountResource {

    @Inject
    AccountService accountService;

    @GET
    @Path("/{accountId}")
    public Response getAccountById(@PathParam("accountId") Long accountId) {
        Account account = accountService.getAccountById(accountId);
        return account != null ? Response.ok(account).build() : Response.status(404).build();
    }

    @GET
    @Path("/{accountId}/balance")
    public Response getAccountBalance(@PathParam("accountId") Long accountId) {
        return Response.ok(accountService.getAccountBalance(accountId)).build();
    }

    @PUT
    @Path("/{accountId}/balance")
    public Response updateAccountBalance(@PathParam("accountId") Long accountId, BigDecimal newBalance) {
        return Response.ok(accountService.updateAccountBalance(accountId, newBalance)).build();
    }

    @GET
    @Path("/{accountId}/validate")
    public Response validateAccount(@PathParam("accountId") Long accountId) {
        return Response.ok(accountService.validateAccount(accountId)).build();
    }

    @POST
    public Response addAccount(Account account) {
        return Response.ok(accountService.addAccount(account)).status(201).build();
    }
}
