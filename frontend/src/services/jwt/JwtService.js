import { jwtDecode } from "jwt-decode";
const decodeToken = (jwt) => {
    try {
        const decoded = jwtDecode(jwt);
        // A estrutura de `decoded` é um objeto contendo o payload do JWT
        //jwtDecode(jwt, { header: true }); // Decodifica o cabeçalho
        return decoded; // Decodifica o corpo
    } catch (error) {
        console.error('Falha ao decodificar o token', error);
    }
};

export default { decodeToken }