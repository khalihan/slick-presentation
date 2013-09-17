import scala.slick.driver.H2Driver.simple._

/*
  Example Data Model
  
  +------------------+
  | COMPUTER         |        
  +------------------+        +---------+
  | ID               |        | COMPANY |
  | NAME             |        +---------+
  | MANUFACTURER_ID--+--------| ID      |
  +------------------+        | NAME    |
                              +---------+
*/
// result types
case class Computer(id: Int, name: String, manufacturerId: Int)
case class Company(id: Int, name: String)

// schema description
class Computers(tag: Tag) extends Table[Computer](tag, "COMPUTER") {
  def id = column[Int]("ID")
  def name = column[String]("NAME")
  def manufacturerId = column[Int]("MANUFACTURER_ID")
  def * = (id, name, manufacturerId) <> (Computer.tupled, Computer.unapply)
}
class Companies(tag: Tag) extends Table[Company](tag, "COMPANY") {
  def id = column[Int]("ID")
  def name = column[String]("NAME")
  def * = (id, name) <> (Company.tupled, Company.unapply)
}

object setup {
  def Computers = TableQuery[Computers]
  def Companies = TableQuery[Companies]

  def initDb(implicit session: Session) = {
    Companies.ddl.create
    Companies ++= Seq(
      Company((1), "Apple Inc."),
      Company((2), "Thinking Machines"),
      Company((3), "RCA"),
      Company((4), "Netronics"),
      Company((5), "Tandy Corporation"),
      Company((6), "Commodore International"),
      Company((7), "MOS Technology"),
      Company((8), "Micro Instrumentation and Telemetry Systems"),
      Company((9), "IMS Associates,  Inc."),
      Company((10), "Digital Equipment Corporation"),
      Company((11), "Lincoln Laboratory"),
      Company((12), "Moore School of Electrical Engineering"),
      Company((13), "IBM"),
      Company((14), "Amiga Corporation"),
      Company((15), "Canon"),
      Company((16), "Nokia"),
      Company((17), "Sony"),
      Company((18), "OQO"),
      Company((19), "NeXT"),
      Company((20), "Atari"),
      Company((22), "Acorn COMPUTER"),
      Company((23), "Timex Sinclair"),
      Company((24), "Nintendo"),
      Company((25), "Sinclair Research Ltd"),
      Company((26), "Xerox"),
      Company((27), "Hewlett-Packard"),
      Company((28), "Zemmix"),
      Company((29), "ACVS"),
      Company((30), "Sanyo"),
      Company((31), "Cray"),
      Company((32), "Evans & Sutherland"),
      Company((33), "E.S.R. Inc."),
      Company((34), "OMRON"),
      Company((35), "BBN Technologies"),
      Company((36), "Lenovo Group"),
      Company((37), "ASUS"),
      Company((38), "Amstrad"),
      Company((39), "Sun Microsystems"),
      Company((40), "Texas Instruments"),
      Company((41), "HTC Corporation"),
      Company((42), "Research In Motion"),
      Company((43), "Samsung Electronics")
    )
    Computers.ddl.create
    Computers ++= Seq(
      Computer((1), "MacBook Pro 15.4 inch", (1)),
      Computer((2), "CM-2a", (2)),
      Computer((3), "CM-200", (2)),
      Computer((4), "CM-5e", (2)),
      Computer((5), "CM-5", (2)),
      Computer((6), "MacBook Pro", (1)),
      Computer((7), "Apple IIe", (1)),
      Computer((8), "Apple IIc", (1)),
      Computer((9), "Apple IIGS", (1)),
      Computer((10), "Apple IIc Plus", (1)),
      Computer((11), "Apple II Plus", (1)),
      Computer((12), "Apple III", (1)),
      Computer((13), "Apple Lisa", (1)),
      Computer((14), "CM-2", (2)),
      Computer((15), "Connection Machine", (2)),
      Computer((16), "Apple II", (1)),
      Computer((17), "Apple III Plus", (1)),
      Computer((18), "COSMAC ELF", (3)),
      Computer((19), "COSMAC VIP", (3)),
      Computer((20), "ELF II", (4)),
      Computer((21), "Macintosh", (1)),
      Computer((22), "Macintosh II", 0),
      Computer((23), "Macintosh Plus", (1)),
      Computer((24), "Macintosh IIfx", 0),
      Computer((25), "iMac", (1)),
      Computer((26), "Mac Mini", (1)),
      Computer((27), "Mac Pro", (1)),
      Computer((28), "Power Macintosh", (1)),
      Computer((29), "PowerBook", (1)),
      Computer((30), "Xserve", 0),
      Computer((31), "Powerbook 100", 0),
      Computer((32), "Powerbook 140", 0),
      Computer((33), "Powerbook 170", 0),
      Computer((34), "PowerBook Duo", 0),
      Computer((35), "PowerBook 190", 0),
      Computer((36), "Macintosh Quadra", (1)),
      Computer((37), "Macintosh Quadra 900", 0),
      Computer((38), "Macintosh Quadra 700", 0),
      Computer((39), "Macintosh LC", (1)),
      Computer((40), "Macintosh LC II", (1)),
      Computer((41), "Macintosh LC III", (1)),
      Computer((42), "Macintosh LC III+", 0),
      Computer((43), "Macintosh Quadra 605", (1)),
      Computer((44), "Macintosh LC 500 series", 0),
      Computer((45), "TRS-80 Color COMPUTER", (5)),
      Computer((46), "Acorn System 2", 0),
      Computer((47), "Dragon 32/64", 0),
      Computer((48), "MEK6800D2", 0),
      Computer((49), "Newbear 77/68", 0),
      Computer((50), "Commodore PET", (6)),
      Computer((51), "Commodore 64", (6)),
      Computer((52), "Commodore 64C", 0),
      Computer((53), "Commodore SX-64", (6)),
      Computer((54), "Commodore 128", (6)),
      Computer((55), "Apple I", (1)),
      Computer((56), "KIM-1", (7)),
      Computer((57), "Altair 8800", (8)),
      Computer((58), "IMSAI 8080", (9)),
      Computer((59), "IMSAI Series Two", 0),
      Computer((60), "VAX", (10)),
      Computer((61), "VAX 11/780", (10)),
      Computer((62), "VAX 11/750", (10)),
      Computer((63), "TX-2", (11)),
      Computer((64), "TX-0", (11)),
      Computer((65), "Whirlwind", (11)),
      Computer((66), "ENIAC", (12)),
      Computer((67), "IBM PC", (13)),
      Computer((68), "Macintosh Classic", 0),
      Computer((69), "Macintosh Classic II", (1)),
      Computer((70), "Amiga", (14)),
      Computer((71), "Amiga 1000", (6)),
      Computer((72), "Amiga 500", (6)),
      Computer((73), "Amiga 500+", 0),
      Computer((74), "Amiga 2000", (6)),
      Computer((75), "Amiga 3000", (6)),
      Computer((76), "Amiga 600", (6)),
      Computer((77), "Macintosh 128K", (1)),
      Computer((78), "Macintosh 512K", (1)),
      Computer((79), "Macintosh SE", (1)),
      Computer((80), "Macintosh SE/30", (1)),
      Computer((81), "Canon Cat", (15)),
      Computer((82), "Nokia 770", (16)),
      Computer((83), "Nokia N800", (16)),
      Computer((84), "Mylo", (17)),
      Computer((85), "OQO 02", (18)),
      Computer((86), "OQO 01+", 0),
      Computer((87), "Pinwheel calculator", 0),
      Computer((88), "iBook", (1)),
      Computer((89), "MacBook", (1)),
      Computer((90), "NeXTstation", (19)),
      Computer((91), "NeXTcube", (19)),
      Computer((92), "NeXTstation Color Turbo", 0),
      Computer((93), "NeXTstation Color", 0),
      Computer((94), "NeXTstation Turbo", 0),
      Computer((95), "NeXTcube Turbo", (19)),
      Computer((96), "NeXTcube 040", (19)),
      Computer((97), "NeXTcube 030", (19)),
      Computer((98), "Tinkertoy Tic-Tac-Toe COMPUTER", 0),
      Computer((99), "Z3", 0),
      Computer((100), "Z4", 0),
      Computer((101), "Z1", 0),
      Computer((102), "Z2", 0),
      Computer((103), "Wang 2200", 0),
      Computer((104), "Wang VS", 0),
      Computer((105), "Wang OIS", 0),
      Computer((106), "BBC Micro", (22)),
      Computer((107), "IBM 650", (13)),
      Computer((108), "Cray-1", 0),
      Computer((109), "Cray-3", 0),
      Computer((110), "Cray-2", 0),
      Computer((111), "Cray-4", 0),
      Computer((112), "Cray X1", 0),
      Computer((113), "Cray XD1", 0),
      Computer((114), "Cray T3D", 0),
      Computer((115), "Cray T3E", 0),
      Computer((116), "Cray C90", 0),
      Computer((117), "Cray T90", 0),
      Computer((118), "Cray SV1", 0),
      Computer((119), "Cray J90", 0),
      Computer((120), "Cray XT3", 0),
      Computer((121), "Cray CS6400", 0),
      Computer((122), "Atari ST", (20)),
      Computer((123), "Amiga 2500", 0),
      Computer((124), "Amiga 2500", (6)),
      Computer((125), "Amiga 4000", (6)),
      Computer((126), "Amiga 3000UX", (6)),
      Computer((127), "Amiga 3000T", (6)),
      Computer((128), "Amiga 4000T", (6)),
      Computer((129), "Amiga 1200", (6)),
      Computer((130), "Atari 1040 STf", 0),
      Computer((131), "Atari 520 ST", 0),
      Computer((132), "Atari 520 STfm", 0),
      Computer((133), "Atari 1040 STe", 0),
      Computer((134), "Atari MEGA STe", 0),
      Computer((135), "Atari 520 ST+", 0),
      Computer((136), "Atari 520 STm", 0),
      Computer((137), "Atari 130 ST", 0),
      Computer((138), "Atari 260 ST", 0),
      Computer((139), "Atari MEGA ST", 0),
      Computer((140), "Atari 520 STf", 0),
      Computer((141), "Atari 1040 STfm", 0),
      Computer((142), "Atari 2080 ST", 0),
      Computer((143), "Atari 260 ST+", 0),
      Computer((144), "Atari 4160 STe", 0),
      Computer((145), "TRS-80 Color COMPUTER 2", 0),
      Computer((146), "TRS-80 Color COMPUTER 3", 0),
      Computer((147), "TRS-80 Model 1", (5)),
      Computer((148), "Timex Sinclair 2068", (23)),
      Computer((149), "ZX Spectrum", (25)),
      Computer((150), "Xerox Star", (26)),
      Computer((151), "Xerox Alto", 0),
      Computer((152), "Acorn Archimedes", (22)),
      Computer((153), "Nintendo Entertainment System", (24)),
      Computer((154), "Super Nintendo Entertainment System", (24)),
      Computer((155), "Super Famicom", 0),
      Computer((156), "Nintendo GameCube", (24)),
      Computer((157), "Game Boy line", 0),
      Computer((158), "PlayStation", (17)),
      Computer((159), "PlayStation 2", (17)),
      Computer((160), "Game & Watch", (24)),
      Computer((161), "EDSAC", 0),
      Computer((162), "IBM System/4 Pi", 0),
      Computer((163), "IBM AP-101", 0),
      Computer((164), "IBM TC-1", 0),
      Computer((165), "IBM AP-101B", 0),
      Computer((166), "IBM AP-101S", (13)),
      Computer((167), "ProLiant", (27)),
      Computer((168), "Http://nepomuk.semanticdesktop.org/xwiki/", 0),
      Computer((169), "Sinclair QL", (25)),
      Computer((170), "Sinclair ZX81", (25)),
      Computer((171), "Sinclair ZX80", (25)),
      Computer((172), "Atari 65XE", (20)),
      Computer((173), "Deep Blue", 0),
      Computer((174), "Macintosh Quadra 650", 0),
      Computer((175), "Macintosh Quadra 610", 0),
      Computer((176), "Macintosh Quadra 800", 0),
      Computer((177), "Macintosh Quadra 950", 0),
      Computer((178), "PowerBook 160", 0),
      Computer((179), "PowerBook 145B", 0),
      Computer((180), "PowerBook 170", 0),
      Computer((181), "PowerBook 145", 0),
      Computer((182), "PowerBook G3", 0),
      Computer((183), "PowerBook 140", 0),
      Computer((184), "Macintosh IIcx", 0),
      Computer((185), "Powerbook 180", 0),
      Computer((186), "PowerBook G4", 0),
      Computer((187), "Macintosh XL", 0),
      Computer((188), "PowerBook 100", 0),
      Computer((189), "PowerBook 2400c", 0),
      Computer((190), "PowerBook 1400", 0),
      Computer((191), "Macintosh Quadra 630", 0),
      Computer((192), "Macintosh Quadra 660AV", 0),
      Computer((193), "Macintosh Quadra 840AV", 0),
      Computer((194), "PowerBook 5300", 0),
      Computer((195), "PowerBook 3400c", 0),
      Computer((196), "Macintosh Color Classic", 0),
      Computer((197), "Macintosh 512Ke", 0),
      Computer((198), "Macintosh IIsi", 0),
      Computer((199), "Macintosh IIx", 0),
      Computer((200), "PowerBook 500 series", 0),
      Computer((201), "Power Macintosh G3", 0),
      Computer((202), "Macintosh IIci", 0),
      Computer((203), "iMac G5", (1)),
      Computer((204), "Power Mac G4", 0),
      Computer((205), "Power Macintosh 7100", 0),
      Computer((206), "Power Macintosh 9600", 0),
      Computer((207), "Power Macintosh 7200", 0),
      Computer((208), "Power Macintosh 7300", 0),
      Computer((209), "Power Macintosh 8600", 0),
      Computer((210), "Power Macintosh 6200", 0),
      Computer((211), "Power Macintosh 8100", 0),
      Computer((212), "Compact Macintosh", 0),
      Computer((213), "Power Macintosh 4400", 0),
      Computer((214), "Power Macintosh 9500", 0),
      Computer((215), "Macintosh Portable", 0),
      Computer((216), "EMac", 0),
      Computer((217), "Power Macintosh 7600", 0),
      Computer((218), "Power Mac G5", 0),
      Computer((219), "Power Macintosh 7500", 0),
      Computer((220), "Power Macintosh 6100", 0),
      Computer((221), "Power Macintosh 8500", 0),
      Computer((222), "Macintosh IIvi", 0),
      Computer((223), "Macintosh IIvx", 0),
      Computer((224), "IMac G3", 0),
      Computer((225), "IMac G4", 0),
      Computer((226), "Power Mac G4 Cube", (1)),
      Computer((227), "Intel iMac", 0),
      Computer((228), "Deep Thought", (13)),
      Computer((229), "Wii", (24)),
      Computer((230), "IBM System x", 0),
      Computer((231), "IBM System i", (13)),
      Computer((232), "IBM System z", (13)),
      Computer((233), "IBM System p", (13)),
      Computer((234), "LC 575", 0),
      Computer((235), "Macintosh TV", 0),
      Computer((236), "Macintosh Performa", 0),
      Computer((237), "Macintosh II series", 0),
      Computer((238), "Power Macintosh 6400", 0),
      Computer((239), "Power Macintosh 6500", 0),
      Computer((240), "Apple PenLite", 0),
      Computer((241), "Wallstreet", 0),
      Computer((242), "Twentieth Anniversary Macintosh", 0),
      Computer((243), "Power Macintosh 5500", 0),
      Computer((244), "iBook G3", (1)),
      Computer((245), "Power Macintosh 5200 LC", 0),
      Computer((246), "Power Macintosh 5400", 0),
      Computer((247), "CM-1", 0),
      Computer((248), "MSX", (28)),
      Computer((249), "PlayStation 3", (17)),
      Computer((250), "MSX2", (29)),
      Computer((251), "MSX2+", (30)),
      Computer((252), "MSX turbo R", 0),
      Computer((253), "Panasonic FS A1GT", 0),
      Computer((254), "Panasonic FS A1ST", 0),
      Computer((255), "PDP-11", (10)),
      Computer((256), "PDP-1", (10)),
      Computer((257), "PDP-10", (10)),
      Computer((258), "PDP-8", (10)),
      Computer((259), "PDP-6", (10)),
      Computer((260), "DECSYSTEM-20", (10)),
      Computer((261), "PDP-7", (10)),
      Computer((262), "PDP-5", (10)),
      Computer((263), "PDP-12", (10)),
      Computer((264), "LINC", (10)),
      Computer((265), "PDP-14", (10)),
      Computer((266), "PDP-15", (10)),
      Computer((267), "PDP-16", (10)),
      Computer((268), "Cray X2", (31)),
      Computer((269), "Cray X-MP", (31)),
      Computer((270), "Evans & Sutherland ES-1", (32)),
      Computer((271), "Commodore VIC-20", (6)),
      Computer((272), "PowerBook 150", 0),
      Computer((273), "MacBook Air", (1)),
      Computer((274), "Digi-Comp I", (33)),
      Computer((275), "Digi-Comp", 0),
      Computer((276), "Digi-Comp II", (33)),
      Computer((277), "Manchester Mark I", 0),
      Computer((278), "Small-Scale Experimental Machine", 0),
      Computer((279), "Nintendo 64", (24)),
      Computer((280), "Game Boy Advance", (24)),
      Computer((281), "Game Boy", (24)),
      Computer((282), "Nintendo DS Lite", (24)),
      Computer((283), "Nintendo DS", (24)),
      Computer((284), "Game Boy Color", (24)),
      Computer((285), "Game Boy Advance SP", (24)),
      Computer((286), "Virtual Boy", (24)),
      Computer((287), "Game Boy Micro", (24)),
      Computer((288), "Roadrunner", (13)),
      Computer((289), "HP 9000", 0),
      Computer((290), "OMRON Luna-88K2", 0),
      Computer((291), "OMRON Luna-88K", (34)),
      Computer((292), "Motorola series 900", 0),
      Computer((293), "Motorola M8120", 0),
      Computer((294), "Triton Dolphin System 100", 0),
      Computer((295), "BBN TC2000", (35)),
      Computer((296), "WRT54G", 0),
      Computer((297), "ThinkPad", (36)),
      Computer((298), "Apple Newton", (1)),
      Computer((299), "Atanasoff-Berry COMPUTER", 0),
      Computer((300), "Atlas COMPUTER", 0),
      Computer((301), "ASUS Eee PC 901", (37)),
      Computer((302), "ASUS Eee PC 701", 0),
      Computer((303), "IBM 7030", (13)),
      Computer((304), "System/38", (13)),
      Computer((305), "System/36", (13)),
      Computer((306), "IBM 7090", (13)),
      Computer((307), "IBM RT", (13)),
      Computer((308), "System/360", (13)),
      Computer((309), "IBM 801", (13)),
      Computer((310), "IBM 1401", (13)),
      Computer((311), "ASCI White", (13)),
      Computer((312), "Blue Gene", (13)),
      Computer((313), "ASCI Blue Pacific", (13)),
      Computer((314), "iPhone", (1)),
      Computer((315), "Nokia N810", (16)),
      Computer((316), "EDSAC 2", 0),
      Computer((317), "Titan", 0),
      Computer((318), "Pilot ACE", 0),
      Computer((319), "HP Mini 1000", (27)),
      Computer((320), "HP 2133 Mini-Note PC", (27)),
      Computer((321), "Kogan Agora Pro", 0),
      Computer((322), "D-Series Machines", 0),
      Computer((323), "ZX Spectrum 48K", (25)),
      Computer((324), "ZX Spectrum 16K", (25)),
      Computer((325), "ZX Spectrum 128", (25)),
      Computer((326), "ZX Spectrum +3", (38)),
      Computer((327), "ZX Spectrum +2", (38)),
      Computer((328), "ZX Spectrum +2A", (38)),
      Computer((329), "ZX Spectrum +", (25)),
      Computer((330), "Acer Extensa", 0),
      Computer((331), "Acer Extensa 5220", 0),
      Computer((332), "Dell Latitude", 0),
      Computer((333), "Toshiba Satellite", 0),
      Computer((334), "Timex Sinclair 2048", (23)),
      Computer((335), "Sprinter", 0),
      Computer((336), "Timex COMPUTER 2048", 0),
      Computer((337), "Pentagon", 0),
      Computer((338), "Belle", 0),
      Computer((339), "Loki", (25)),
      Computer((340), "Hobbit", 0),
      Computer((341), "NeXT COMPUTER", (19)),
      Computer((342), "TRS-80", 0),
      Computer((343), "TRS-80 Model 2", (5)),
      Computer((344), "TRS-80 Model 3", (5)),
      Computer((345), "STacy", 0),
      Computer((346), "ST BOOK", 0),
      Computer((347), "Atari 520 STE", 0),
      Computer((348), "Amiga 2000 Model A", 0),
      Computer((349), "Amiga 2000 Model B", 0),
      Computer((350), "Amiga 2000 Model C", 0),
      Computer((351), "IBM 3270", 0),
      Computer((352), "CALDIC", 0),
      Computer((353), "Modbook", 0),
      Computer((354), "Compaq SystemPro", 0),
      Computer((355), "ARRA", 0),
      Computer((356), "IBM System Cluster 1350", 0),
      Computer((357), "Finite element machine", 0),
      Computer((358), "ES7000", 0),
      Computer((359), "HP MediaSmart Server", 0),
      Computer((360), "HP Superdome", 0),
      Computer((361), "IBM Power Systems", (13)),
      Computer((362), "Oslo Analyzer", 0),
      Computer((363), "Microsoft Softcard", 0),
      Computer((364), "WITCH", 0),
      Computer((365), "Analytical engine", 0),
      Computer((366), "EDVAC", 0),
      Computer((367), "BINAC", 0),
      Computer((368), "Earth Simulator", 0),
      Computer((369), "BARK", 0),
      Computer((370), "Harvard Mark I", (13)),
      Computer((371), "ILLIAC IV", 0),
      Computer((372), "ILLIAC II", 0),
      Computer((373), "ILLIAC III", 0),
      Computer((374), "Water integrator", 0),
      Computer((375), "CSIRAC", 0),
      Computer((376), "System X", 0),
      Computer((377), "Harvest", 0),
      Computer((378), "ChipTest", 0),
      Computer((379), "HiTech", 0),
      Computer((380), "Bomba", 0),
      Computer((381), "ACE", 0),
      Computer((382), "ASCI Red", 0),
      Computer((383), "ASCI Thors Hammer", 0),
      Computer((384), "ASCI Purple", (13)),
      Computer((385), "ASCI Blue Mountain", 0),
      Computer((386), "Columbia", 0),
      Computer((387), "HP Integrity", 0),
      Computer((388), "APEXC", 0),
      Computer((389), "Datasaab D2", 0),
      Computer((390), "BRLESC", 0),
      Computer((391), "DYSEAC", 0),
      Computer((392), "SSEC", (13)),
      Computer((393), "Hydra", 0),
      Computer((394), "FUJIC", 0),
      Computer((395), "RAYDAC", 0),
      Computer((396), "Harvard Mark III", 0),
      Computer((397), "DATAR", 0),
      Computer((398), "ReserVec", 0),
      Computer((399), "DASK", 0),
      Computer((400), "UTEC", 0),
      Computer((401), "DRTE COMPUTER", 0),
      Computer((402), "PowerEdge", 0),
      Computer((403), "Apple Network Server", 0),
      Computer((404), "Goodyear MPP", 0),
      Computer((405), "Macintosh 128K technical details", 0),
      Computer((406), "Power Macintosh G3", 0),
      Computer((407), "CER-10", 0),
      Computer((408), "CER-20", 0),
      Computer((409), "IBM BladeCenter", (13)),
      Computer((410), "Wisconsin Integrally Synchronized COMPUTER", 0),
      Computer((411), "Amstrad CPC", (38)),
      Computer((412), "Amstrad CPC 6128", (38)),
      Computer((413), "Amstrad CPC 664", (38)),
      Computer((414), "Amstrad CPC 464", (38)),
      Computer((415), "Intergraph", 0),
      Computer((416), "Enterprise", 0),
      Computer((417), "MTX500", 0),
      Computer((418), "Acorn Electron", 0),
      Computer((419), "Sony Vaio P", (17)),
      Computer((420), "VAIO", (17)),
      Computer((421), "Sony Vaio P VGN-P588E/Q", 0),
      Computer((422), "Sony Vaio P VGN-P530H/G", 0),
      Computer((423), "Sony Vaio P VGN-P530H/W", 0),
      Computer((424), "Sony Vaio P VGN-P530H/Q", 0),
      Computer((425), "Sony Vaio P VGN-P530H/R", 0),
      Computer((426), "Sony Vaio P VGN-P588E/R", 0),
      Computer((427), "Sony Vaio P VGN-P598E/Q", 0),
      Computer((428), "Timex Sinclair 1000", (23)),
      Computer((429), "Komputer 2086", 0),
      Computer((430), "Galaksija", 0),
      Computer((431), "Vector-06C", 0),
      Computer((432), "Elektronika BK", 0),
      Computer((433), "Sun386i", (39)),
      Computer((434), "Xerox Daybreak", 0),
      Computer((435), "Xerox NoteTaker", (26)),
      Computer((436), "D4a", 0),
      Computer((437), "LGP-30", 0),
      Computer((438), "LGP-21", 0),
      Computer((439), "ASUS Eee PC 900", (37)),
      Computer((440), "Atari TT030", 0),
      Computer((441), "Bi Am ZX-Spectrum 48/64", 0),
      Computer((442), "Bi Am ZX-Spectrum 128", 0),
      Computer((443), "PlayStation Portable", 0),
      Computer((444), "MSI Wind Netbook", 0),
      Computer((445), "Sharp Mebius NJ70A", 0),
      Computer((446), "HTC Snap", (41)),
      Computer((447), "Commodore Educator 64", (6)),
      Computer((448), "Amiga 1500", (6)),
      Computer((449), "Commodore 65", (6)),
      Computer((450), "Commodore 16", (6)),
      Computer((451), "Commodore CBM-II", (6)),
      Computer((452), "Commodore Plus/4", (6)),
      Computer((453), "Commodore LCD", (6)),
      Computer((454), "Commodore MAX Machine", (6)),
      Computer((455), "Aster CT-80", 0),
      Computer((456), "Test", 0),
      Computer((457), "MSI GX723", 0),
      Computer((458), "Eee PC 1000HV", 0),
      Computer((459), "VTech Laser 200", 0),
      Computer((460), "CrunchPad", 0),
      Computer((461), "Neo Geo", 0),
      Computer((462), "Sega Mega Drive", 0),
      Computer((463), "Sega Master System", 0),
      Computer((464), "TurboGrafx-16", 0),
      Computer((465), "Sun-3", (39)),
      Computer((466), "Pleiades", 0),
      Computer((467), "IBM Sequoia", 0),
      Computer((468), "Inves Spectrum 48k plus", 0),
      Computer((469), "iPhone 3G", 0),
      Computer((470), "iPhone 3GS", 0),
      Computer((471), "Beagle Board", (40)),
      Computer((472), "HP nPar", 0),
      Computer((473), "MacBook Family", 0),
      Computer((474), "Reservisor", 0),
      Computer((475), "BladeSystem", 0),
      Computer((476), "lenovo thinkpad t60p", 0),
      Computer((477), "lenovo thinkpad x200", (36)),
      Computer((478), "lenovo thinkpad t60", 0),
      Computer((479), "lenovo thinkpad w700", 0),
      Computer((480), "lenovo thinkpad t41", 0),
      Computer((481), "lenovo thinkpad z61p", 0),
      Computer((482), "lenovo thinkpad x61s", 0),
      Computer((483), "lenovo thinkpad t43", 0),
      Computer((484), "lenovo thinkpad r400", 0),
      Computer((485), "lenovo thinkpad x60s", 0),
      Computer((486), "lenovo thinkpad x301", 0),
      Computer((487), "lenovo thinkpad t42", 0),
      Computer((488), "lenovo thinkpad r61", 0),
      Computer((489), "lenovo thinkpad w500", 0),
      Computer((490), "lenovo thinkpad sl400", 0),
      Computer((491), "lenovo thinkpad x40", 0),
      Computer((492), "lenovo thinkpad x200 tablet", (36)),
      Computer((493), "lenovo thinkpad t400s", 0),
      Computer((494), "Nokia N900", (16)),
      Computer((495), "Internet Tablet", 0),
      Computer((496), "Meiko Computing Surface", 0),
      Computer((497), "CS-2", 0),
      Computer((498), "IBM 701", (13)),
      Computer((499), "IBM 5100", (13)),
      Computer((500), "AN/FSQ-7", (13)),
      Computer((501), "AN/FSQ-32", (13)),
      Computer((502), "IBM CPC", (13)),
      Computer((503), "System/34", (13)),
      Computer((504), "System/32", (13)),
      Computer((505), "System/3", (13)),
      Computer((506), "IBM 305", (13)),
      Computer((507), "English Electric DEUCE", 0),
      Computer((508), "CER-203", 0),
      Computer((509), "CER-22", 0),
      Computer((510), "Kentucky Linux Athlon Testbed", 0),
      Computer((511), "QNAP TS-101", 0),
      Computer((512), "iPad", (1)),
      Computer((513), "iPhone 2G", 0),
      Computer((514), "Inslaw", 0),
      Computer((515), "WePad", 0),
      Computer((516), "MacBook Parts", (1)),
      Computer((517), "MacBook 13-inch Core 2 Duo 2.13GHz (MC240LL/A) DDR2 Model", (1)),
      Computer((518), "MacBook 13-inch Core 2 Duo 2.13GHz (MC240T/A) DDR2 Model", 0),
      Computer((519), "MacBook 13-inch Core 2 Duo 2.13GHz (MC240X/A) DDR2 Model", 0),
      Computer((520), "MacBook 13-inch Core 2 Duo 2.26GHz (Unibody MC207LL/A) DDR3 Model", 0),
      Computer((521), "MC240LL/A", 0),
      Computer((522), "D.K.COMMUNICATION", 0),
      Computer((523), "iPhone 4", (1)),
      Computer((524), "Nintendo 3DS", (24)),
      Computer((525), "ASUS Eee PC 1005PE", (37)),
      Computer((526), "National Law Enforcement System", 0),
      Computer((527), "BlackBerry PlayBook", (42)),
      Computer((528), "Barnes & Noble nook", 0),
      Computer((529), "SAM Coupé", 0),
      Computer((530), "HTC Dream", (41)),
      Computer((531), "Samsung Galaxy Tab", (43)),
      Computer((532), "BlackBerry PlayBook", (42)),
      Computer((533), "Tianhe-I", 0),
      Computer((534), "Kno", 0),
      Computer((535), "ThinkPad 701 C", 0),
      Computer((536), "ThinkPad 340 CSE", 0),
      Computer((537), "ThinkPad 755 CX", 0),
      Computer((538), "ThinkPad 755 CE", 0),
      Computer((539), "ThinkPad 370 C", 0),
      Computer((540), "Coleco Adam", 0),
      Computer((541), "Nebulae", 0),
      Computer((542), "Alex eReader", 0),
      Computer((543), "Acer Iconia", 0),
      Computer((544), "Archos 101", 0),
      Computer((545), "Fujitsu Lifebook T900", 0),
      Computer((546), "Motorola Xoom", 0),
      Computer((547), "ViewSonic G Tablet", 0),
      Computer((548), "DEC Professional", (10)),
      Computer((549), "DEC Multia", (10)),
      Computer((550), "DEC Firefly", (10)),
      Computer((551), "DEC 3000 AXP", (10)),
      Computer((552), "DEC 2000 AXP", (10)),
      Computer((553), "DEC 4000 AXP", (10)),
      Computer((554), "DEC 7000/10000 AXP", (10)),
      Computer((555), "DEC Professional 350", 0),
      Computer((556), "DEC Rainbow 100", 0),
      Computer((557), "DEC Professional 325", 0),
      Computer((558), "DECmate II", (10)),
      Computer((559), "DECmate", (10)),
      Computer((560), "DECsystem", (10)),
      Computer((561), "NetApp Filer", 0),
      Computer((562), "DEC GT40", (10)),
      Computer((563), "ecoATM", 0),
      Computer((564), "MindWave BrainCubed Education Bundle", 0),
      Computer((565), "PalmPilot", 0),
      Computer((566), "Upcoming iPhone 5", (1)),
      Computer((567), "Dell Inspiron 560 Desktop COMPUTER ", 0),
      Computer((568), "IPad 2", (1)),
      Computer((569), "HP TouchPad", (27)),
      Computer((570), "HP Veer", (27)),
      Computer((571), "Lenovo Thinkpad Edge 11", (36)),
      Computer((572), "Dell Vostro", 0),
      Computer((573), "Gateway LT3103U", 0),
      Computer((574), "iPhone 4S", (1))
    )
  }
}
