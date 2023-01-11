package lecture.jdbc.vo;

public class BookInfVO {

	private int bnumber;
	private String pid;
	private String bisbn;
	private String btitle;
	private String bdate;
	private int bpage;
	private int bprice;
	private String bauthor;
	private String btranslator;
	private String bsupplement;
	private String bpublisher;
	private String bimgurl;
	private int bborrowdate;
	private int breturndate;
	private int bpoint;
	private String bhave;

	public BookInfVO() {
		super();
	}
	
	public BookInfVO(String pid, String bhave, int bpoint) {
		super();
		this.pid = pid;
		this.bhave = bhave;
		this.bpoint = bpoint;
	}

	public BookInfVO(int bnumber, String bisbn, String bhave) {
		super();
		this.bnumber = bnumber;
		this.bisbn = bisbn;
		this.bhave = bhave;
	}
	
	public BookInfVO(int bnumber, String pid, int bpoint) {
		super();
		this.bnumber = bnumber;
		this.pid = pid;
		this.bpoint = bpoint;
	}

	public BookInfVO(String pid, String bisbn, String btitle, String bdate, int bpage, int bprice, String bauthor,
			int bborrowdate, int breturndate, int bpoint, String bhave) {
		super();
		this.pid = pid;
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bpage = bpage;
		this.bprice = bprice;
		this.bauthor = bauthor;
		this.bborrowdate = bborrowdate;
		this.breturndate = breturndate;
		this.bpoint = bpoint;
		this.bhave = bhave;
	}

	public BookInfVO(String pid, String bisbn, String btitle, String bdate, int bpage, int bprice, String bauthor,
			int bpoint, String bhave) {
		super();
		this.pid = pid;
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bpage = bpage;
		this.bprice = bprice;
		this.bauthor = bauthor;
		this.bpoint = bpoint;
		this.bhave = bhave;
	}

	public BookInfVO(String pid, int bnumber, String bisbn, String btitle, String bdate, int bpage, int bprice,
			String bauthor, int bborrowdate, int breturndate, int bpoint, String bhave) {
		super();
		this.bnumber = bnumber;
		this.pid = pid;
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bpage = bpage;
		this.bprice = bprice;
		this.bauthor = bauthor;
		this.bborrowdate = bborrowdate;
		this.breturndate = breturndate;
		this.bpoint = bpoint;
		this.bhave = bhave;
	}

	public BookInfVO(String bisbn, String btitle, String bdate, int bpage, int bprice, String bauthor, String btranslator,
			String bsupplement, String bpublisher, String bimgurl) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bpage = bpage;
		this.bprice = bprice;
		this.bauthor = bauthor;
		this.btranslator = btranslator;
		this.bsupplement = bsupplement;
		this.bpublisher = bpublisher;
		this.bimgurl = bimgurl;
	}


	public BookInfVO(String bisbn, String btitle, String bdate, String bauthor, int bpage, int bprice, 
			String btranslator, String bsupplement, String bpublisher, String bimgurl, String bhave) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bpage = bpage;
		this.bprice = bprice;
		this.bauthor = bauthor;
		this.btranslator = btranslator;
		this.bsupplement = bsupplement;
		this.bpublisher = bpublisher;
		this.bimgurl = bimgurl;
		this.bhave = bhave;
	}

	public BookInfVO(int bnumber, String pid, String bisbn, String btitle, String bdate, int bpage, int bprice,
			String bauthor, String btranslator, String bsupplement, String bpublisher, String bimgurl, int bborrowdate,
			int breturndate, int bpoint, String bhave) {
		super();
		this.bnumber = bnumber;
		this.pid = pid;
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bpage = bpage;
		this.bprice = bprice;
		this.bauthor = bauthor;
		this.btranslator = btranslator;
		this.bsupplement = bsupplement;
		this.bpublisher = bpublisher;
		this.bimgurl = bimgurl;
		this.bborrowdate = bborrowdate;
		this.breturndate = breturndate;
		this.bpoint = bpoint;
		this.bhave = bhave;
	}

	public BookInfVO(String pid, String bisbn, String btitle, int bpage, String bdate, int bprice,
			String bauthor, String btranslator, String bsupplement, String bpublisher, String imgurl) {
		this.pid = pid;
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bpage = bpage;
		this.bprice = bprice;
		this.bauthor = bauthor;
		this.btranslator = btranslator;
		this.bsupplement = bsupplement;
		this.bpublisher = bpublisher;
	}

	public int getBnumber() {
		return bnumber;
	}

	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBpage() {
		return bpage;
	}

	public void setBpage(int bpage) {
		this.bpage = bpage;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBtranslator() {
		return btranslator;
	}

	public void setBtranslator(String btranslator) {
		this.btranslator = btranslator;
	}

	public String getBsupplement() {
		return bsupplement;
	}

	public void setBsupplement(String bsupplement) {
		this.bsupplement = bsupplement;
	}

	public String getBpublisher() {
		return bpublisher;
	}

	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}

	public String getBimgurl() {
		return bimgurl;
	}

	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
	}

	public int getBborrowdate() {
		return bborrowdate;
	}

	public void setBborrowdate(int bborrowdate) {
		this.bborrowdate = bborrowdate;
	}

	public int getBreturndate() {
		return breturndate;
	}

	public void setBreturndate(int breturndate) {
		this.breturndate = breturndate;
	}

	public int getBpoint() {
		return bpoint;
	}

	public void setBpoint(int bpoint) {
		this.bpoint = bpoint;
	}

	public String getBhave() {
		return bhave;
	}

	public void setBhave(String bhave) {
		this.bhave = bhave;
	}

}
