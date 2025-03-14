import java.time.LocalDate

object LensPerson:
   case class Person(_name: Name, _born: Born, _address: Address)

   case class Name(_foreNames: String /*Space separated*/, _surName: String)

   // Value of java.time.LocalDate.toEpochDay
   private type EpochDay = Long

   case class Born(_bornAt: Address, _bornOn: EpochDay)

   case class Address(_street: String, _houseNumber: Int, _place: String /*Village / city*/, _country: String)

   // Valid values of Gregorian are those for which 'java.time.LocalDate.of'
   // returns a valid LocalDate.
   case class Gregorian(_year: Int, _month: Int, _dayOfMonth: Int)

   // Implement these.

   val bornStreet: Born => String =
      (b: Born) => b._bornAt._street

   val setCurrentStreet: String => Person => Person =
      (s: String) => (p: Person) => p.copy(_address = p._address.copy(_street = s))

   val setBirthMonth: Int => Person => Person =
      (i: Int) =>
         (p: Person) =>
            p.copy(_born = p._born.copy(_bornOn = LocalDate.ofEpochDay(p._born._bornOn).withMonth(i).toEpochDay))

   // Transform both birth and current street names.
   val renameStreets: (String => String) => Person => Person =
      (f: String => String) =>
         (p: Person) =>
            setCurrentStreet(f(p._address._street))(p).copy(_born =
               p._born.copy(_bornAt = p._born._bornAt.copy(_street = f(bornStreet(p._born)))))
