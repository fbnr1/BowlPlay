# BowlPlay [HWR OOP]

This repository contains a student project created for an ongoing lecture on object-oriented programming with Java at HWR Berlin (summer term 2022).

> :warning: This code is for educational purpose only. Do not rely on it!


## Abstract
Unser Projekt bezieht sich das Spiel Bowling, in Anlehnung an das BowlingKata (https://ccd-school.de/coding-dojo/class-katas/bowling/). 
Dabei geht es darum, in 10 Durchgängen (Frames), in der Regel bestehend aus jeweils 2 Würfen (Rolls), mit einem Ball möglichst viele Pins umzuwerfen. 
Es stehen maximal 10 Pins pro Durchgang zum Umwerfen zur Verfügung. Bei normaler Zählweise der Punkte entspricht ein umgeworfener Pin einem Punkt. 
Dabei gibt es Sonderfälle, welche vor allem einen Einfluss auf die Punktzählweise oder die Wurfanzahl haben. Diese Sonderfälle 
sind Strike und Spare, welche eintreffen, wenn in einem Durchgang alle 10 Pins umgeworfen werden. Das Spiel kann von mindestens einer und 
maximal fünf Personen gleichzeitig gespielt werden.


Die wichtigsten features:
- Hinzufügen von Spielern 
- Spielerbegrenzung (mind. 1 - max. 5) 
- Kontrolle des Wurfrechts und Zählung der Durchgänge bzw. Würfe 
- Überprüfung ob regelkonformer Wurf 
- Berechnung des Punktestandes 
- Kontrolle der Sonderfälle (Strike & Spare) sowie die entsprechende besondere Zählweise 
- Überprüfung des Spielendes
- 

Die interessantesten Probleme die wir hatten:
- die verkettete Zählweise der Punkte bei Sonderwürfen (Strike und Spare) -> doppelte Punktzahl in 1/2 nächsten Würfen
- der Entstehungsprozess, von einem realen Problem zu einem fertigen Programm
- Modellierung der Klassen und Objekte und das Zusammenwirken dieser
- Komplizierte Berechnung der Punktzahlen


## Feature List

| Number | Feature         | Tests           |
|--------|-----------------|-----------------|
| 1      | Game            | GameTest (13)   |
| 2      | Player          | PlayerTest (12) |
| 3      | ScoreCalculator | PlayerTest (12) |
| 4      | Frame           | FrameTest (14)  |
| 5      | Roll            | RollTest (3)    |


## Additional Dependencies

| Number | Dependency Name | Dependency Description | Why is it necessary? |
|--------|-----------------|------------------------|----------------------|
| 1      | /               | /                      | /                    |
