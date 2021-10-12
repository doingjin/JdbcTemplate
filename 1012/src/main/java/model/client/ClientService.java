package model.client;

import java.util.List;

public interface ClientService {
	void insertC(ClientVO cvo);
	void updateC(ClientVO cvo);
	void deleteC(ClientVO cvo);
	ClientVO login(ClientVO cvo);
	List<ClientVO> getCList();
}
