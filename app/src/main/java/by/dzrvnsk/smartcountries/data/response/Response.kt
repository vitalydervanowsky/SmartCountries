package by.dzrvnsk.smartcountries.data.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CoatOfArms(
    @SerializedName("svg") val svg: String? = null,
    @SerializedName("png") val png: String? = null
) : Serializable

data class BOB(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Hgm(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Pih(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Aze(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Ltz(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class CNY(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class SSP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Cym(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class NPR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class LSL(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class KES(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Nau(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Sqi(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Kat(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Maps(
    @SerializedName("openStreetMaps") val openStreetMaps: String? = null,
    @SerializedName("googleMaps") val googleMaps: String? = null
) : Serializable

data class NativeName(
    @SerializedName("spa") val spa: Spa? = null,
    @SerializedName("zul") val zul: Zul? = null,
    @SerializedName("tso") val tso: Tso? = null,
    @SerializedName("ssw") val ssw: Ssw? = null,
    @SerializedName("nbl") val nbl: Nbl? = null,
    @SerializedName("sot") val sot: Sot? = null,
    @SerializedName("nso") val nso: Nso? = null,
    @SerializedName("afr") val afr: Afr? = null,
    @SerializedName("tsn") val tsn: Tsn? = null,
    @SerializedName("ven") val ven: Ven? = null,
    @SerializedName("xho") val xho: Xho? = null,
    @SerializedName("eng") val eng: Eng? = null,
    @SerializedName("tam") val tam: Tam? = null,
    @SerializedName("sin") val sin: Sin? = null,
    @SerializedName("smo") val smo: Smo? = null,
    @SerializedName("kor") val kor: Kor? = null,
    @SerializedName("ita") val ita: Ita? = null,
    @SerializedName("cnr") val cnr: Cnr? = null,
    @SerializedName("ces") val ces: Ces? = null,
    @SerializedName("slk") val slk: Slk? = null,
    @SerializedName("hun") val hun: Hun? = null,
    @SerializedName("kat") val kat: Kat? = null,
    @SerializedName("por") val por: Por? = null,
    @SerializedName("fra") val fra: Fra? = null,
    @SerializedName("ara") val ara: Ara? = null,
    @SerializedName("zdj") val zdj: Zdj? = null,
    @SerializedName("ltz") val ltz: Ltz? = null,
    @SerializedName("deu") val deu: Deu? = null,
    @SerializedName("kwn") val kwn: Kwn? = null,
    @SerializedName("her") val her: Her? = null,
    @SerializedName("loz") val loz: Loz? = null,
    @SerializedName("ndo") val ndo: Ndo? = null,
    @SerializedName("hgm") val hgm: Hgm? = null,
    @SerializedName("srp") val srp: Srp? = null,
    @SerializedName("cat") val cat: Cat? = null,
    @SerializedName("gsw") val gsw: Gsw? = null,
    @SerializedName("roh") val roh: Roh? = null,
    @SerializedName("hin") val hin: Hin? = null,
    @SerializedName("lit") val lit: Lit? = null,
    @SerializedName("lat") val lat: Lat? = null,
    @SerializedName("nfr") val nfr: Nfr? = null,
    @SerializedName("nrf") val nrf: Nrf? = null,
    @SerializedName("jam") val jam: Jam? = null,
    @SerializedName("msa") val msa: Msa? = null,
    @SerializedName("run") val run: Run? = null,
    @SerializedName("tvl") val tvl: Tvl? = null,
    @SerializedName("nld") val nld: Nld? = null,
    @SerializedName("swa") val swa: Swa? = null,
    @SerializedName("sag") val sag: Sag? = null,
    @SerializedName("ell") val ell: Ell? = null,
    @SerializedName("pap") val pap: Pap? = null,
    @SerializedName("swe") val swe: Swe? = null,
    @SerializedName("fin") val fin: Fin? = null,
    @SerializedName("nya") val nya: Nya? = null,
    @SerializedName("sqi") val sqi: Sqi? = null,
    @SerializedName("zho") val zho: Zho? = null,
    @SerializedName("ton") val ton: Ton? = null,
    @SerializedName("som") val som: Som? = null,
    @SerializedName("slv") val slv: Slv? = null,
    @SerializedName("hif") val hif: Hif? = null,
    @SerializedName("fij") val fij: Fij? = null,
    @SerializedName("mfe") val mfe: Mfe? = null,
    @SerializedName("tkl") val tkl: Tkl? = null,
    @SerializedName("grn") val grn: Grn? = null,
    @SerializedName("rus") val rus: Rus? = null,
    @SerializedName("kaz") val kaz: Kaz? = null,
    @SerializedName("nob") val nob: Nob? = null,
    @SerializedName("nno") val nno: Nno? = null,
    @SerializedName("smi") val smi: Smi? = null,
    @SerializedName("kal") val kal: Kal? = null,
    @SerializedName("dan") val dan: Dan? = null,
    @SerializedName("pov") val pov: Pov? = null,
    @SerializedName("khm") val khm: Khm? = null,
    @SerializedName("tir") val tir: Tir? = null,
    @SerializedName("mah") val mah: Mah? = null,
    @SerializedName("vie") val vie: Vie? = null,
    @SerializedName("ben") val ben: Ben? = null,
    @SerializedName("prs") val prs: Prs? = null,
    @SerializedName("tuk") val tuk: Tuk? = null,
    @SerializedName("pus") val pus: Pus? = null,
    @SerializedName("jpn") val jpn: Jpn? = null,
    @SerializedName("hye") val hye: Hye? = null,
    @SerializedName("que") val que: Que? = null,
    @SerializedName("aym") val aym: Aym? = null,
    @SerializedName("lao") val lao: Lao? = null,
    @SerializedName("bjz") val bjz: Bjz? = null,
    @SerializedName("tet") val tet: Tet? = null,
    @SerializedName("ukr") val ukr: Ukr? = null,
    @SerializedName("aze") val aze: Aze? = null,
    @SerializedName("niu") val niu: Niu? = null,
    @SerializedName("tgk") val tgk: Tgk? = null,
    @SerializedName("kin") val kin: Kin? = null,
    @SerializedName("hrv") val hrv: Hrv? = null,
    @SerializedName("kir") val kir: Kir? = null,
    @SerializedName("gle") val gle: Gle? = null,
    @SerializedName("glv") val glv: Glv? = null,
    @SerializedName("bos") val bos: Bos? = null,
    @SerializedName("lav") val lav: Lav? = null,
    @SerializedName("mya") val mya: Mya? = null,
    @SerializedName("est") val est: Est? = null,
    @SerializedName("pih") val pih: Pih? = null,
    @SerializedName("div") val div: Div? = null,
    @SerializedName("fas") val fas: Fas? = null,
    @SerializedName("fil") val fil: Fil? = null,
    @SerializedName("fao") val fao: Fao? = null,
    @SerializedName("cha") val cha: Cha? = null,
    @SerializedName("cal") val cal: Cal? = null,
    @SerializedName("nep") val nep: Nep? = null,
    @SerializedName("mri") val mri: Mri? = null,
    @SerializedName("nzs") val nzs: Nzs? = null,
    @SerializedName("tur") val tur: Tur? = null,
    @SerializedName("lin") val lin: Lin? = null,
    @SerializedName("kon") val kon: Kon? = null,
    @SerializedName("bis") val bis: Bis? = null,
    @SerializedName("mlg") val mlg: Mlg? = null,
    @SerializedName("amh") val amh: Amh? = null,
    @SerializedName("bul") val bul: Bul? = null,
    @SerializedName("bar") val bar: Bar? = null,
    @SerializedName("sna") val sna: Sna? = null,
    @SerializedName("ndc") val ndc: Ndc? = null,
    @SerializedName("khi") val khi: Khi? = null,
    @SerializedName("nde") val nde: Nde? = null,
    @SerializedName("toi") val toi: Toi? = null,
    @SerializedName("kck") val kck: Kck? = null,
    @SerializedName("zib") val zib: Zib? = null,
    @SerializedName("bwg") val bwg: Bwg? = null,
    @SerializedName("tha") val tha: Tha? = null,
    @SerializedName("arc") val arc: Arc? = null,
    @SerializedName("ckb") val ckb: Ckb? = null,
    @SerializedName("ind") val ind: Ind? = null,
    @SerializedName("dzo") val dzo: Dzo? = null,
    @SerializedName("gil") val gil: Gil? = null,
    @SerializedName("lua") val lua: Lua? = null,
    @SerializedName("mkd") val mkd: Mkd? = null,
    @SerializedName("rar") val rar: Rar? = null,
    @SerializedName("ber") val ber: Ber? = null,
    @SerializedName("mlt") val mlt: Mlt? = null,
    @SerializedName("heb") val heb: Heb? = null,
    @SerializedName("isl") val isl: Isl? = null,
    @SerializedName("bel") val bel: Bel? = null,
    @SerializedName("urd") val urd: Urd? = null,
    @SerializedName("hmo") val hmo: Hmo? = null,
    @SerializedName("tpi") val tpi: Tpi? = null,
    @SerializedName("nau") val nau: Nau? = null,
    @SerializedName("hat") val hat: Hat? = null,
    @SerializedName("nor") val nor: Nor? = null,
    @SerializedName("crs") val crs: Crs? = null,
    @SerializedName("mon") val mon: Mon? = null,
    @SerializedName("uzb") val uzb: Uzb? = null,
    @SerializedName("pau") val pau: Pau? = null,
    @SerializedName("mey") val mey: Mey? = null
) : Serializable

data class Bis(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Isl(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Gil(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class BND(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Fil(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class LRD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class MOP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class PLN(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class KID(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Bar(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Fra(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null,
    @SerializedName("f") val f: String? = null,
    @SerializedName("m") val m: String? = null
) : Serializable

data class JEP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class LBP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class XAF(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class PostalCode(
    @SerializedName("regex") val regex: String? = null,
    @SerializedName("format") val format: String? = null
) : Serializable

data class ISK(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Bre(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Ndc(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class ANG(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class CZK(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class CUP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class SRD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class LYD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Mah(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class MVR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Flags(
    @SerializedName("svg") val svg: String? = null,
    @SerializedName("png") val png: String? = null,
    @SerializedName("alt") val alt: String? = null
) : Serializable

data class GYD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Cha(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class OMR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class FOK(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class CHF(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class TND(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Lav(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Ssw(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Pov(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Nfr(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Nde(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class AED(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class SCR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Som(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Zib(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Bwg(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class KWD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class DJF(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Msa(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class MMK(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Prs(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class GNF(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Eng(
    @SerializedName("f") val f: String? = null,
    @SerializedName("m") val m: String? = null,
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Nld(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class BHD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class MXN(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class KPW(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class VUV(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class STN(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class PHP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Lao(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Per(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Grn(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class CapitalInfo(
    @SerializedName("latlng") val latlng: List<Double?>? = null
) : Serializable

data class Fin(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Hat(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class SGD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Swa(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Tsn(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Gle(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Slk(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Afr(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class PKR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Div(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Name(
    @SerializedName("nativeName") val nativeName: NativeName? = null,
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Khi(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class RUB(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Kwn(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class QAR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class GIP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class USD(

    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Roh(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class MAD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Amh(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Ber(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class GBP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class LAK(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Tgk(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Nya(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class XCD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class BTN(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class WST(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

/*data class Ron(
@SerializedName("common") val common: String? = null,
@SerializedName("official") val official: String? = null
) : Serializable*/

data class Nor(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Toi(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class SEK(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Tam(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class GMD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class ETB(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class NIO(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class DZD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Rar(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Tir(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class AZN(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class IQD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Vie(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Swe(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Lin(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Gsw(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Srp(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class TWD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class BWP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class TRY(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class CAD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class JPY(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class MWK(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class UAH(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class CLP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Mri(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Kor(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Pap(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Nbl(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

/*data class MKD(
@SerializedName("symbol") val symbol: String? = null,
@SerializedName("name") val name: String? = null
) : Serializable*/

data class KYD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class ILS(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Nzs(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class GGP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Kir(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Hif(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Smo(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class BBD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Nob(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class PAB(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class CRC(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Hin(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class HUF(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class BDT(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Ukr(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Zul(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class SOS(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class PGK(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Bul(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class ERN(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Tso(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Sot(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Urd(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class ARS(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class SDG(
    @SerializedName("name") val name: String? = null
) : Serializable

data class DOP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class BMD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Dzo(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class MRU(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Cat(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Loz(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class VND(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Hrv(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Jam(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Sin(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Country(
    @SerializedName("capital") val capital: List<String?>? = null,
    @SerializedName("flag") val flag: String? = null,
    @SerializedName("independent") val independent: Boolean? = null,
    @SerializedName("landlocked") val landlocked: Boolean? = null,
    @SerializedName("borders") val borders: List<String?>? = null,
    @SerializedName("postalCode") val postalCode: PostalCode? = null,
    @SerializedName("flags") val flags: Flags? = null,
    @SerializedName("capitalInfo") val capitalInfo: CapitalInfo? = null,
    @SerializedName("ccn3") val ccn3: String? = null,
    @SerializedName("coatOfArms") val coatOfArms: CoatOfArms? = null,
    @SerializedName("demonyms") val demonyms: Demonyms? = null,
    @SerializedName("fifa") val fifa: String? = null,
    @SerializedName("cioc") val cioc: String? = null,
    @SerializedName("car") val car: Car? = null,
    @SerializedName("altSpellings") val altSpellings: List<String?>? = null,
    @SerializedName("area") val area: Double? = null,
    @SerializedName("languages") val languages: Languages? = null,
    @SerializedName("maps") val maps: Maps? = null,
    @SerializedName("subregion") val subregion: String? = null,
    @SerializedName("idd") val idd: Idd? = null,
    @SerializedName("tld") val tld: List<String?>? = null,
    @SerializedName("unMember") val unMember: Boolean? = null,
    @SerializedName("continents") val continents: List<String?>? = null,
    @SerializedName("population") val population: Int? = null,
    @SerializedName("startOfWeek") val startOfWeek: String? = null,
    @SerializedName("timezones") val timezones: List<String?>? = null,
    @SerializedName("name") val name: Name? = null,
    @SerializedName("cca3") val cca3: String? = null,
    @SerializedName("region") val region: String? = null,
    @SerializedName("latlng") val latlng: List<Double?>? = null,
    @SerializedName("cca2") val cca2: String? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("currencies") val currencies: Currencies? = null
) : Serializable

data class SHP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Rus(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Languages(
    @SerializedName("spa") val spa: String? = null,
    @SerializedName("zul") val zul: String? = null,
    @SerializedName("tso") val tso: String? = null,
    @SerializedName("ssw") val ssw: String? = null,
    @SerializedName("nbl") val nbl: String? = null,
    @SerializedName("sot") val sot: String? = null,
    @SerializedName("nso") val nso: String? = null,
    @SerializedName("afr") val afr: String? = null,
    @SerializedName("tsn") val tsn: String? = null,
    @SerializedName("ven") val ven: String? = null,
    @SerializedName("xho") val xho: String? = null,
    @SerializedName("eng") val eng: String? = null,
    @SerializedName("tam") val tam: String? = null,
    @SerializedName("sin") val sin: String? = null,
    @SerializedName("smo") val smo: String? = null,
    @SerializedName("kor") val kor: String? = null,
    @SerializedName("ita") val ita: String? = null,
    @SerializedName("cnr") val cnr: String? = null,
    @SerializedName("ces") val ces: String? = null,
    @SerializedName("slk") val slk: String? = null,
    @SerializedName("hun") val hun: String? = null,
    @SerializedName("kat") val kat: String? = null,
    @SerializedName("por") val por: String? = null,
    @SerializedName("fra") val fra: String? = null,
    @SerializedName("ara") val ara: String? = null,
    @SerializedName("zdj") val zdj: String? = null,
    @SerializedName("ltz") val ltz: String? = null,
    @SerializedName("deu") val deu: String? = null,
    @SerializedName("kwn") val kwn: String? = null,
    @SerializedName("her") val her: String? = null,
    @SerializedName("loz") val loz: String? = null,
    @SerializedName("ndo") val ndo: String? = null,
    @SerializedName("hgm") val hgm: String? = null,
    @SerializedName("srp") val srp: String? = null,
    @SerializedName("cat") val cat: String? = null,
    @SerializedName("gsw") val gsw: String? = null,
    @SerializedName("roh") val roh: String? = null,
    @SerializedName("hin") val hin: String? = null,
    @SerializedName("lit") val lit: String? = null,
    @SerializedName("lat") val lat: String? = null,
    @SerializedName("nfr") val nfr: String? = null,
    @SerializedName("nrf") val nrf: String? = null,
    @SerializedName("jam") val jam: String? = null,
    @SerializedName("msa") val msa: String? = null,
    @SerializedName("run") val run: String? = null,
    @SerializedName("tvl") val tvl: String? = null,
    @SerializedName("nld") val nld: String? = null,
    @SerializedName("swa") val swa: String? = null,
    @SerializedName("sag") val sag: String? = null,
    @SerializedName("ell") val ell: String? = null,
    @SerializedName("pap") val pap: String? = null,
    @SerializedName("swe") val swe: String? = null,
    @SerializedName("fin") val fin: String? = null,
    @SerializedName("nya") val nya: String? = null,
    @SerializedName("sqi") val sqi: String? = null,
    @SerializedName("zho") val zho: String? = null,
    @SerializedName("ton") val ton: String? = null,
    @SerializedName("som") val som: String? = null,
    @SerializedName("slv") val slv: String? = null,
    @SerializedName("hif") val hif: String? = null,
    @SerializedName("fij") val fij: String? = null,
    @SerializedName("ron") val ron: String? = null,
    @SerializedName("pol") val pol: String? = null,
    @SerializedName("mfe") val mfe: String? = null,
    @SerializedName("tkl") val tkl: String? = null,
    @SerializedName("grn") val grn: String? = null,
    @SerializedName("rus") val rus: String? = null,
    @SerializedName("kaz") val kaz: String? = null,
    @SerializedName("nob") val nob: String? = null,
    @SerializedName("nno") val nno: String? = null,
    @SerializedName("smi") val smi: String? = null,
    @SerializedName("kal") val kal: String? = null,
    @SerializedName("dan") val dan: String? = null,
    @SerializedName("pov") val pov: String? = null,
    @SerializedName("khm") val khm: String? = null,
    @SerializedName("tir") val tir: String? = null,
    @SerializedName("mah") val mah: String? = null,
    @SerializedName("vie") val vie: String? = null,
    @SerializedName("ben") val ben: String? = null,
    @SerializedName("prs") val prs: String? = null,
    @SerializedName("tuk") val tuk: String? = null,
    @SerializedName("pus") val pus: String? = null,
    @SerializedName("jpn") val jpn: String? = null,
    @SerializedName("hye") val hye: String? = null,
    @SerializedName("que") val que: String? = null,
    @SerializedName("aym") val aym: String? = null,
    @SerializedName("lao") val lao: String? = null,
    @SerializedName("bjz") val bjz: String? = null,
    @SerializedName("tet") val tet: String? = null,
    @SerializedName("ukr") val ukr: String? = null,
    @SerializedName("aze") val aze: String? = null,
    @SerializedName("niu") val niu: String? = null,
    @SerializedName("tgk") val tgk: String? = null,
    @SerializedName("kin") val kin: String? = null,
    @SerializedName("hrv") val hrv: String? = null,
    @SerializedName("kir") val kir: String? = null,
    @SerializedName("gle") val gle: String? = null,
    @SerializedName("glv") val glv: String? = null,
    @SerializedName("bos") val bos: String? = null,
    @SerializedName("lav") val lav: String? = null,
    @SerializedName("mya") val mya: String? = null,
    @SerializedName("est") val est: String? = null,
    @SerializedName("pih") val pih: String? = null,
    @SerializedName("div") val div: String? = null,
    @SerializedName("fas") val fas: String? = null,
    @SerializedName("fil") val fil: String? = null,
    @SerializedName("fao") val fao: String? = null,
    @SerializedName("cha") val cha: String? = null,
    @SerializedName("cal") val cal: String? = null,
    @SerializedName("nep") val nep: String? = null,
    @SerializedName("mri") val mri: String? = null,
    @SerializedName("nzs") val nzs: String? = null,
    @SerializedName("tur") val tur: String? = null,
    @SerializedName("lin") val lin: String? = null,
    @SerializedName("kon") val kon: String? = null,
    @SerializedName("bis") val bis: String? = null,
    @SerializedName("mlg") val mlg: String? = null,
    @SerializedName("amh") val amh: String? = null,
    @SerializedName("bul") val bul: String? = null,
    @SerializedName("de") val de: String? = null,
    @SerializedName("sna") val sna: String? = null,
    @SerializedName("ndc") val ndc: String? = null,
    @SerializedName("khi") val khi: String? = null,
    @SerializedName("nde") val nde: String? = null,
    @SerializedName("toi") val toi: String? = null,
    @SerializedName("kck") val kck: String? = null,
    @SerializedName("zib") val zib: String? = null,
    @SerializedName("bwg") val bwg: String? = null,
    @SerializedName("tha") val tha: String? = null,
    @SerializedName("arc") val arc: String? = null,
    @SerializedName("ckb") val ckb: String? = null,
    @SerializedName("ind") val ind: String? = null,
    @SerializedName("dzo") val dzo: String? = null,
    @SerializedName("gil") val gil: String? = null,
    @SerializedName("lua") val lua: String? = null,
    @SerializedName("mkd") val mkd: String? = null,
    @SerializedName("rar") val rar: String? = null,
    @SerializedName("ber") val ber: String? = null,
    @SerializedName("mlt") val mlt: String? = null,
    @SerializedName("heb") val heb: String? = null,
    @SerializedName("isl") val isl: String? = null,
    @SerializedName("bel") val bel: String? = null,
    @SerializedName("urd") val urd: String? = null,
    @SerializedName("hmo") val hmo: String? = null,
    @SerializedName("tpi") val tpi: String? = null,
    @SerializedName("nau") val nau: String? = null,
    @SerializedName("hat") val hat: String? = null,
    @SerializedName("nor") val nor: String? = null,
    @SerializedName("crs") val crs: String? = null,
    @SerializedName("mon") val mon: String? = null,
    @SerializedName("uzb") val uzb: String? = null,
    @SerializedName("pau") val pau: String? = null,
    @SerializedName("mey") val mey: String? = null
) : Serializable

data class BRL(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class HTG(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Por(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class SZL(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Cnr(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class IDR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class JOD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Nep(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Ind(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class UGX(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class KMF(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class CKD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class INR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class AWG(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Mon(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Idd(
    @SerializedName("suffixes") val suffixes: List<String?>? = null,
    @SerializedName("root") val root: String? = null
) : Serializable

data class SLL(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Her(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Kck(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class GTQ(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Car(
    @SerializedName("side") val side: String? = null,
    @SerializedName("signs") val signs: List<String?>? = null
) : Serializable

data class MYR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Heb(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Sag(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class RWF(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Zdj(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Slv(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Zho(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Hmo(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class KHR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Hye(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Ita(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Bos(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class EGP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class BIF(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Nrf(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class PEN(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class MUR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Tuk(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Tur(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Mey(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Aym(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Kin(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class UYU(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class SAR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Lit(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Est(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class AMD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class GEL(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class SYP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class MDL(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Run(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Que(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Kal(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class TOP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class EUR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class BGN(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class TMT(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Lat(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Hun(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class ZWL(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Tha(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Mfe(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class AOA(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Khm(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Ndo(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class UZS(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Arc(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class BAM(
    @SerializedName("name") val name: String? = null
) : Serializable

data class IMP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class THB(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Tet(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class NZD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Niu(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Crs(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class COP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class BZD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Bjz(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class FJD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class ALL(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class VES(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class XPF(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Nno(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class TVD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class YER(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Ara(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Kon(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Mkd(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class KRW(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class CVE(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Ben(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class ZAR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Tpi(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class ZMW(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class PYG(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Lua(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class XOF(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Uzb(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Deu(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Fas(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class RSD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class IRR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Bel(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class MNT(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Pus(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Sna(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Kaz(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class AUD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Xho(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class AFN(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Jpn(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class SBD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Cal(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Pau(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class MZN(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class HNL(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class BSD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class BYN(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class TTD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Mlg(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class NAD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class CDF(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class TZS(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class KZT(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Spa(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Fao(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class NOK(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class LKR(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Demonyms(
    @SerializedName("fra") val fra: Fra? = null,
    @SerializedName("eng") val eng: Eng? = null
) : Serializable

data class Ton(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class RON(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Fij(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Ell(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Nso(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class JMD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Currencies(
    @SerializedName("NIO") val nIO: NIO? = null,
    @SerializedName("ZAR") val zAR: ZAR? = null,
    @SerializedName("LKR") val lKR: LKR? = null,
    @SerializedName("USD") val uSD: USD? = null,
    @SerializedName("XCD") val xCD: XCD? = null,
    @SerializedName("COP") val cOP: COP? = null,
    @SerializedName("UYU") val uYU: UYU? = null,
    @SerializedName("KRW") val kRW: KRW? = null,
    @SerializedName("EUR") val eUR: EUR? = null,
    @SerializedName("CZK") val cZK: CZK? = null,
    @SerializedName("HUF") val hUF: HUF? = null,
    @SerializedName("GEL") val gEL: GEL? = null,
    @SerializedName("XAF") val xAF: XAF? = null,
    @SerializedName("PAB") val pAB: PAB? = null,
    @SerializedName("KMF") val kMF: KMF? = null,
    @SerializedName("GBP") val gBP: GBP? = null,
    @SerializedName("SHP") val sHP: SHP? = null,
    @SerializedName("JOD") val jOD: JOD? = null,
    @SerializedName("NAD") val nAD: NAD? = null,
    @SerializedName("RSD") val rSD: RSD? = null,
    @SerializedName("DJF") val dJF: DJF? = null,
    @SerializedName("CHF") val cHF: CHF? = null,
    @SerializedName("INR") val iNR: INR? = null,
    @SerializedName("SYP") val sYP: SYP? = null,
    @SerializedName("CVE") val cVE: CVE? = null,
    @SerializedName("GGP") val gGP: GGP? = null,
    @SerializedName("JEP") val jEP: JEP? = null,
    @SerializedName("AED") val aED: AED? = null,
    @SerializedName("JMD") val jMD: JMD? = null,
    @SerializedName("GNF") val gNF: GNF? = null,
    @SerializedName("GMD") val gMD: GMD? = null,
    @SerializedName("MYR") val mYR: MYR? = null,
    @SerializedName("BIF") val bIF: BIF? = null,
    @SerializedName("GIP") val gIP: GIP? = null,
    @SerializedName("XPF") val xPF: XPF? = null,
    @SerializedName("XOF") val xOF: XOF? = null,
    @SerializedName("VES") val vES: VES? = null,
    @SerializedName("AUD") val aUD: AUD? = null,
    @SerializedName("TVD") val tVD: TVD? = null,
    @SerializedName("KES") val kES: KES? = null,
    @SerializedName("AWG") val aWG: AWG? = null,
    @SerializedName("MWK") val mWK: MWK? = null,
    @SerializedName("ALL") val aLL: ALL? = null,
    @SerializedName("SGD") val sGD: SGD? = null,
    @SerializedName("BND") val bND: BND? = null,
    @SerializedName("HKD") val hKD: HKD? = null,
    @SerializedName("TOP") val tOP: TOP? = null,
    @SerializedName("SOS") val sOS: SOS? = null,
    @SerializedName("BHD") val bHD: BHD? = null,
    @SerializedName("NZD") val nZD: NZD? = null,
    @SerializedName("SEK") val sEK: SEK? = null,
    @SerializedName("BBD") val bBD: BBD? = null,
    @SerializedName("GYD") val gYD: GYD? = null,
    @SerializedName("STN") val sTN: STN? = null,
    @SerializedName("FJD") val fJD: FJD? = null,
    @SerializedName("CNY") val cNY: CNY? = null,
    @SerializedName("MDL") val mDL: MDL? = null,
    @SerializedName("PLN") val pLN: PLN? = null,
    @SerializedName("MUR") val mUR: MUR? = null,
    @SerializedName("PYG") val pYG: PYG? = null,
    @SerializedName("KZT") val kZT: KZT? = null,
    @SerializedName("NOK") val nOK: NOK? = null,
    @SerializedName("DKK") val dKK: DKK? = null,
    @SerializedName("SSP") val sSP: SSP? = null,
    @SerializedName("BRL") val bRL: BRL? = null,
    @SerializedName("KHR") val kHR: KHR? = null,
    @SerializedName("ERN") val eRN: ERN? = null,
    @SerializedName("ZMW") val zMW: ZMW? = null,
    @SerializedName("SBD") val sBD: SBD? = null,
    @SerializedName("MOP") val mOP: MOP? = null,
    @SerializedName("VND") val vND: VND? = null,
    @SerializedName("BSD") val bSD: BSD? = null,
    @SerializedName("CAD") val cAD: CAD? = null,
    @SerializedName("BMD") val bMD: BMD? = null,
    @SerializedName("BDT") val bDT: BDT? = null,
    @SerializedName("QAR") val qAR: QAR? = null,
    @SerializedName("AFN") val aFN: AFN? = null,
    @SerializedName("JPY") val jPY: JPY? = null,
    @SerializedName("AMD") val aMD: AMD? = null,
    @SerializedName("PEN") val pEN: PEN? = null,
    @SerializedName("LAK") val lAK: LAK? = null,
    @SerializedName("BZD") val bZD: BZD? = null,
    @SerializedName("FKP") val fKP: FKP? = null,
    @SerializedName("UAH") val uAH: UAH? = null,
    @SerializedName("AZN") val aZN: AZN? = null,
    @SerializedName("SDG") val sDG: SDG? = null,
    @SerializedName("ARS") val aRS: ARS? = null,
    @SerializedName("SRD") val sRD: SRD? = null,
    @SerializedName("CLP") val cLP: CLP? = null,
    @SerializedName("TJS") val tJS: TJS? = null,
    @SerializedName("TND") val tND: TND? = null,
    @SerializedName("KYD") val kYD: KYD? = null,
    @SerializedName("GHS") val gHS: GHS? = null,
    @SerializedName("SLL") val sLL: SLL? = null,
    @SerializedName("RWF") val rWF: RWF? = null,
    @SerializedName("LSL") val lSL: LSL? = null,
    @SerializedName("KGS") val kGS: KGS? = null,
    @SerializedName("IMP") val iMP: IMP? = null,
    @SerializedName("KWD") val kWD: KWD? = null,
    @SerializedName("MRU") val mRU: MRU? = null,
    @SerializedName("BAM") val bAM: BAM? = null,
    @SerializedName("RUB") val rUB: RUB? = null,
    @SerializedName("ANG") val aNG: ANG? = null,
    @SerializedName("MMK") val mMK: MMK? = null,
    @SerializedName("TMT") val tMT: TMT? = null,
    @SerializedName("MXN") val mXN: MXN? = null,
    @SerializedName("DZD") val dZD: DZD? = null,
    @SerializedName("LYD") val lYD: LYD? = null,
    @SerializedName("CUC") val cUC: CUC? = null,
    @SerializedName("CUP") val cUP: CUP? = null,
    @SerializedName("MVR") val mVR: MVR? = null,
    @SerializedName("IRR") val iRR: IRR? = null,
    @SerializedName("PHP") val pHP: PHP? = null,
    @SerializedName("FOK") val fOK: FOK? = null,
    @SerializedName("NPR") val nPR: NPR? = null,
    @SerializedName("YER") val yER: YER? = null,
    @SerializedName("TRY") val tRY: TRY? = null,
    @SerializedName("VUV") val vUV: VUV? = null,
    @SerializedName("MGA") val mGA: MGA? = null,
    @SerializedName("RON") val rON: RON? = null,
    @SerializedName("ETB") val eTB: ETB? = null,
    @SerializedName("BGN") val bGN: BGN? = null,
    @SerializedName("TZS") val tZS: TZS? = null,
    @SerializedName("DOP") val dOP: DOP? = null,
    @SerializedName("TTD") val tTD: TTD? = null,
    @SerializedName("WST") val wST: WST? = null,
    @SerializedName("ZWL") val zWL: ZWL? = null,
    @SerializedName("THB") val tHB: THB? = null,
    @SerializedName("IQD") val iQD: IQD? = null,
    @SerializedName("KPW") val kPW: KPW? = null,
    @SerializedName("EGP") val eGP: EGP? = null,
    @SerializedName("ILS") val iLS: ILS? = null,
    @SerializedName("IDR") val iDR: IDR? = null,
    @SerializedName("BTN") val bTN: BTN? = null,
    @SerializedName("SZL") val sZL: SZL? = null,
    @SerializedName("KID") val kID: KID? = null,
    @SerializedName("LRD") val lRD: LRD? = null,
    @SerializedName("LBP") val lBP: LBP? = null,
    @SerializedName("CDF") val cDF: CDF? = null,
    @SerializedName("CKD") val cKD: CKD? = null,
    @SerializedName("MAD") val mAD: MAD? = null,
    @SerializedName("OMR") val oMR: OMR? = null,
    @SerializedName("ISK") val iSK: ISK? = null,
    @SerializedName("BYN") val bYN: BYN? = null,
    @SerializedName("AOA") val aOA: AOA? = null,
    @SerializedName("GTQ") val gTQ: GTQ? = null,
    @SerializedName("SAR") val sAR: SAR? = null,
    @SerializedName("BWP") val bWP: BWP? = null,
    @SerializedName("UGX") val uGX: UGX? = null,
    @SerializedName("PKR") val pKR: PKR? = null,
    @SerializedName("MZN") val mZN: MZN? = null,
    @SerializedName("PGK") val pGK: PGK? = null,
    @SerializedName("HTG") val hTG: HTG? = null,
    @SerializedName("SCR") val sCR: SCR? = null,
    @SerializedName("MNT") val mNT: MNT? = null,
    @SerializedName("BOB") val bOB: BOB? = null,
    @SerializedName("UZS") val uZS: UZS? = null,
    @SerializedName("HNL") val hNL: HNL? = null,
    @SerializedName("CRC") val cRC: CRC? = null,
    @SerializedName("TWD") val tWD: TWD? = null,
    @SerializedName("NGN") val nGN: NGN? = null
) : Serializable

data class Tkl(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class NGN(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Mlt(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class FKP(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class GHS(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Mya(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class KGS(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Ces(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Dan(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Ven(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class MGA(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class CUC(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class DKK(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Tvl(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Glv(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class TJS(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class HKD(
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("name") val name: String? = null
) : Serializable

data class Ckb(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable

data class Smi(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
) : Serializable
