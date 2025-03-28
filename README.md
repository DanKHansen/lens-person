# Lens Person

Welcome to Lens Person on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Use lenses to update nested records (specific to languages with immutable data).

Updating fields of nested, immutable records is kind of annoying.
The code for such cases is as cumbersome as the structure is deep.
If you have, say, a Person, that contains an Address, which has a Street, that has a Number,
updating the Number requires creating a new Street with the new Number, then a new Address with the
new Street and, finally, a new Person with the new Address.
Confused already?

One solution to this problem is to use [lenses][lenses].

Implement several record accessing functions using lenses.
The test suite also allows you to avoid lenses altogether so you can experiment with different
approaches.

[lenses]: https://en.wikibooks.org/wiki/Haskell/Lenses_and_functional_references

In Scala, a popular alternative for using Lens that is supported
by Exercism is [Monocle](https://www.optics.dev/Monocle/)

## Source

### Created by

- @abo64

### Contributed to by

- @ErikSchierboom
- @ppartarr
- @rajeshpg
- @ricemery