package jukebox.assignment.jukebox.service.constants;

public enum DownStreamAPI {
	GET_JUKES("http://my-json-server.typicode.com/touchtunes/tech-assignment/jukes"),
	GET_SETTINGS("http://my-json-server.typicode.com/touchtunes/tech-assignment/settings");

	private final String uri;

	public String getUri() {
		return uri;
	}

	private DownStreamAPI(String uri) {
		this.uri = uri;
	}

}
