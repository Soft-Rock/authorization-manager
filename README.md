# authorization-manager

Authorization management library.

This library is about access-control. It is not about authentication.

This library is written in Kotlin.

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

- Update role description.
- Appoint user as [role].
- Withdraw user from [role].
- Update permission description.
- Assign a permission to a role.
- Assign a set of permissions to a role.
- Withdraw a permission from a role.
- Withdraw a set of permissions from a role.
- Respond whether a permission is assigned to a role.
- Respond whether a user has a permission.

## TODO
- val permissions: Set<Permission> -> val permissions: Permissions