# InventoryEventAPI (FORK)
Original Author: *Wertik*

Forked from: *https://github.com/Wertik/InventoryEventsAPI*

Replacement for InventoryClose&amp;OpenEvents.


## Changes from original

Removed bloat, replaced NMS with ProtocolLib (mandatory dependency).

## Usage

Initialize using ``InventoryEventAPI#register(JavaPlugin plugin)`` and then listen for `PlayerInventoryCloseEvent` and/or `PlayerInventoryOpenEvent`.

## Maven

```xml
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>

	<dependency>
	    <groupId>com.github.Drc-DEV</groupId>
	    <artifactId>InventoryEventsAPI</artifactId>
	    <version>LATEST</version>
        <scope>compile</scope>
	</dependency>
```
