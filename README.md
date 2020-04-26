# Authorization manager server

![](https://github.com/authorization-manager/server/workflows/Push%20to%20master%20CI/badge.svg)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=authorization-manager_server&metric=alert_status)](https://sonarcloud.io/dashboard?id=authorization-manager_server)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=authorization-manager_server&metric=bugs)](https://sonarcloud.io/dashboard?id=authorization-manager_server)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=authorization-manager_server&metric=code_smells)](https://sonarcloud.io/dashboard?id=authorization-manager_server)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=authorization-manager_server&metric=coverage)](https://sonarcloud.io/dashboard?id=authorization-manager_server)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=authorization-manager_server&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=authorization-manager_server)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=authorization-manager_server&metric=ncloc)](https://sonarcloud.io/dashboard?id=authorization-manager_server)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=authorization-manager_server&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=authorization-manager_server)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=authorization-manager_server&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=authorization-manager_server)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=authorization-manager_server&metric=security_rating)](https://sonarcloud.io/dashboard?id=authorization-manager_server)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=authorization-manager_server&metric=sqale_index)](https://sonarcloud.io/dashboard?id=authorization-manager_server)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=authorization-manager_server&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=authorization-manager_server)



Authorization management library.

This library is about access-control. It is not about authentication.

## Why?
Authorization management has become a *commodity*.

**Reduce time to market using authorization-manager**

## Key concepts

- User: person that use the service/product/system where this library is used.
- Permission: ability to access information or perform an action. Permissions have a *description*
- Role: set of permissions. Roles have a description.

## Rules

- Users, permissions and roles have to be uniquely identifiable.
- A user can be appointed as many roles.
- A role can have many assigned permissions.
- A user has a permission if he is appointed as some role that has that permission

## Features

- Update permission description.
- Assign a permission to a role.
- Assign a set of permissions to a role.
- Withdraw a permission from a role.
- Withdraw a set of permissions from a role.
- Respond whether a permission is assigned to a role.
- Appoint user as [role].
- Withdraw user from [role].
- Respond whether a permission is assigned to a user.
